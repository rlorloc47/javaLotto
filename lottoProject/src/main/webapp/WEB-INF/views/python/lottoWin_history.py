import requests
from bs4 import BeautifulSoup
import pymysql
import time

#전역변수 선언부
conn = None
cur = None

sql = ""

#메인코드
conn = pymysql.connect(host='bettereun47.cafe24.com', user='bettereun47', password ='P@ssw0rd', db = 'bettereun47', charset = 'utf8')
cur = conn.cursor()

sql = "INSERT INTO tb21_130_lotto_win(history_idx,address_ori,auto_type,win_order,company_name,write_time) VALUES (%s,%s,%s,%s,%s,%s)"

for page in range(1,978):
        page = 978
        url = 'https://www.dhlottery.co.kr/store.do?method=topStore&pageGubun=L645&drwNo='+str(page)
        print(url)

        response = requests.get(url)
        if response.status_code == 200:
                html = response.text
                soup = BeautifulSoup(html, 'html.parser')
                history_idx = page

                address_ori = soup.select('#article > div:nth-child(2) > div > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(4)').get_text()
                print(address_ori)

                win_order = soup.select_one('#article > div:nth-child(2) > div > div:nth-child(4) > div > h4').get_text()

                auto_type = soup.select_one('#article > div:nth-child(2) > div > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(3)').get_text()

                company_name = soup.select_one('#article > div:nth-child(2) > div > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(1)').get_text()

                now = time.localtime()
                write_time = "%04d%02d%02d%02d%02d%02d" % (now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min, now.tm_sec)

                insertList = [history_idx,address_ori,auto_type,win_order,company_name,write_time]
                cur.execute(sql, insertList)
                conn.commit()
        else :
                print(response.status_code)
