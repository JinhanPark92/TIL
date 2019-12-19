from flask import Flask, render_template, request
import datetime
import random
import requests

# 지금부터 flask 서버의 이름이 app
app = Flask(__name__)

# url 을 관리해주는 친구 > @app.route
@app.route("/")
def hello():
    return "안녕!"


@app.route("/dday")
def dday():
    today = datetime.datetime.now()
    print(today)
    final =datetime.datetime(2020, 6, 9)
    result = final - today
    print(result)
    return f"{result.days}일 남았습니다."


# is it christmas 실습
#'/christmas'
@app.route('/christmas')
def christmas():
    today = datetime.datetime.now()
    month = today.date().month
    day = today.date().day
    print(today.date().strftime("%Y년 %n월 %d일"))
    if month == 12 and day == 25:
        return "<h1>YES</h1>"
    else:
        return "<h1>NO</h1>"

@app.route("/movies")
def movies():
    movies = ["나홀로집에", "겨울왕국2", "클라우스", "어바웃타임", "러브 엑츄얼리"]
    return render_template("movie.html", movies=movies)

@app.route("/greeting/<string:name>")
def greeting(name):
    print(name)
    return f"안녕하세요! {name}님!"

@app.route("/cube/<int:num>")
def cube(num):
    result = num ** 3
    return str(result)

#식사 메뉴 추천
# 1. random
# 2. DR_url : @app.route("/lunch/1 2 3 4")
# - List : ["짜장면", "짬뽕", "오므라이스", "볶음밥", "울면"]
# - <int : num> 숫자 만큼 뽑기
# 3. print(선택된 메뉴들)
# 4. return ""

@app.route("/lunch/<int:num>")
def lunch(num):
    menu = ["짜장면", "짬뽕", "오므라이스", "볶음밥", "울면", "팔보채"]
    c_menu = random.sample(menu, num)
    return render_template("lunch.html", movies = c_menu)

@app.route("/vonvon")
def vonvon():
    return render_template("vonvon.html")

@app.route("/godmademe")
def godmademe():
    name = request.args.get("name")
    print(name)    
    
    first_list = ["이쁨", "귀여움", "착하게생김", "강아지상"]
    c_first_list = random.choice(first_list)
    second_list = ["애교", "사랑스러움", "활발함"]
    c_second_list = random.choice(second_list)
    third_list = ["정치질", "식욕", "운명의 상대"]
    c_third_list = random.choice(third_list)
   
    return render_template("godmademe.html", name=name, first_list=c_first_list, second_list=c_second_list, third_list=c_third_list)

    
    
    
    ###
    ###

# flask run
# python app.py
if __name__ == "__main__":
    app.run(debug=True)
    