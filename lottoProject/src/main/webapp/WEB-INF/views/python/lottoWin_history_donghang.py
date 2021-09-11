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

for page in range(928,978):
    url = 'https://www.dhlottery.co.kr/store.do?method=topStore&pageGubun=L645&drwNo='+str(page)
    print(url)

    response = requests.get(url)
    if response.status_code == 200:
            html = response.text
            soup = BeautifulSoup(html, 'html.parser')
            history_idx = page

            table = soup.select('.group_content')
            print('table : ',len(table))

            for tableInt in range(1,(len(table)+1)):
                win_order = soup.select_one('#article > div:nth-child(2) > div > div:nth-child('+str(tableInt+3)+') > div > h4').get_text().replace('등 배출점','')
                print('win_order : ',win_order)

                tr = soup.select('#article > div:nth-child(2) > div > div:nth-child('+str(tableInt+3)+') > table > tbody > tr')

                print('tr 길이 : ',len(tr))

                for trInt in range(1,(len(tr)+1)):
                    trCount = 2
                    company_name = soup.select_one('#article > div:nth-child(2) > div > div:nth-child('+str(tableInt+3)+') > table > tbody > tr:nth-child('+str(trInt)+') > td:nth-child('+str(trCount)+')').get_text()
                    if(tableInt==1):
                        trCount+= 1
                        auto_type = soup.select_one('#article > div:nth-child(2) > div > div:nth-child('+str(tableInt+3)+') > table > tbody > tr:nth-child('+str(trInt)+') > td:nth-child('+str(trCount)+')').get_text().strip()
                        print('table : ',tableInt,' / auto_type : ',auto_type)
                        if auto_type == "자동":
                            auto_type_code = "AM001"
                        else:
                            auto_type_code = "AM002"
                    else:
                        auto_type_code = "AM003"

                    trCount+= 1
                    address_ori = soup.select_one('#article > div:nth-child(2) > div > div:nth-child('+str(tableInt+3)+') > table > tbody > tr:nth-child('+str(trInt)+') > td:nth-child('+str(trCount)+')').get_text()

                    now = time.localtime()
                    write_time = "%04d%02d%02d%02d%02d%02d" % (now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min, now.tm_sec)

                    print('history_idx : ',history_idx,' / address_ori : ',address_ori,' / win_order : ',win_order,' / company_name : ',company_name,' / write_time : ',write_time)
                    insertList = [history_idx,address_ori,auto_type_code,win_order,company_name,write_time]
                    cur.execute(sql, insertList)
                    conn.commit()
                
                    
            else :
                    print('response.status_code : ',response.status_code)
