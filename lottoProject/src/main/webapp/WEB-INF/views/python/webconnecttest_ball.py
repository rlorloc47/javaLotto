import requests
from bs4 import BeautifulSoup
import pymysql
import time

#전역변수 선언부
conn = None
cur = None

sql = ""

#메인코드
conn = pymysql.connect(host='221.154.250.171', user='root', password ='raspberry', db = 'lotto_db', charset = 'utf8')
cur = conn.cursor()

sql = "INSERT INTO tb21_110_lotto_ball(history_idx,ball_number,bonus_yn) VALUES (%s,%s,%s)"

for page in range(1,978):
    url = 'https://search.naver.com/search.naver?sm=tab_drt&where=nexearch&query='+str(page)+'%ED%9A%8C%EB%A1%9C%EB%98%90'
    print(url)

    response = requests.get(url)

    if response.status_code == 200:
        html = response.text
        soup = BeautifulSoup(html, 'html.parser')
        #print(soup.select_one('#_lotto > div > div.lotto_tit > h3 > a > em'))
        history_idx = soup.select_one('#_lotto > div > div.lotto_tit > h3 > a > em').get_text().split('회')[0]
        history_date = soup.select_one('#_lotto > div > div.lotto_tit > h3 > a > span').get_text().replace('.','')
        #print(history_date)
        ballList = soup.select('#_lotto > div > div.num_box > span')
        #print(len(ballList))
        for ball in ballList:
            if ball.get_text()!='보너스번호':
                #print(ball.get_text())
                if ball is ballList[-1]:
                    bonus_yn = 'Y'
                else :
                    bonus_yn = 'N'

                now = time.localtime()
                write_time = "%04d%02d%02d%02d%02d%02d" % (now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min, now.tm_sec)
                #insertList = [history_idx,history_date,ball.get_text(),bonus_yn,write_time]
                insertList = [history_idx,ball.get_text(),bonus_yn]
                cur.execute(sql, insertList)
                conn.commit()
            
    else : 
        print(response.status_code)
