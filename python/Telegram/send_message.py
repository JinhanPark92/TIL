import requests
from decouple import config

token = config('TELEGRAM_BOT_TOKEN')
app_url = f"https://api.telegram.org/bot{token}"
chat_id = config('CHAT_ID')

text = "곧 점심시간 입니다."

message_url = app_url + f"/sendMessage?chat_id={chat_id}&text={text}"

requests.get(message_url)