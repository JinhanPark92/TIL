# Github로 Web page 만들기

## 1. 준비사항

* [StrarBootstrap](https://startbootstrap.com/) 에서 양식 다운로드
* 다운로드 된 파일에서 Git Bash를 열고 'git init' 활성화하기.
* 'git add .' 활성화
* 'git commit -m '~' ' 활성화
* github에 'user name'.github.io으로 원격 저장소 생성
* 'git remote add origin <url>' 명령어로 git에게 원격 서버 주소 알려주기
* 'git push origin master' 활성화하기

## 2. Visual Studio Code 활용하기

> visual studio code는 메모장의 상위호환
>
> 문서 편집기(모든 소스 코드의 문서 작업가능)

* StrarBootstrap으로 다운받은 항목들 중, index파일 활성화
* 수정을 원하는 부분에 마우스 오른쪽 클릭 -> 검사 -> 해당 코드 확인 후, Visual studio를 활용하여 수정 및 저장
  * 원하는 폰트는 [Fontawesome](https://fontawesome.com/) 사이트에서 검색 ->  코드 확인.
* git commit -am ~을 통해 add 및 commit 한번에 하기
* push 후, 새로고침하여 웹 상에서 확인.
  * 수정이 안되어 있으면 웹 상에서 마우스 오른쪽 클릭 -> 검사 -> 새로고침 오른쪽 클릭 -> 캐시 비우기 및 새로고침해서 수정 다시 한번 확인하기

## 3. 마크다운 기반 블로그

> 정적 탬플릿 생성기 : MD -> html/css로 바꿔준다.

### 3-1 Jekyll

* 꽤 오래됨. 래퍼런스 많음. 카카오 기술블로그 기반



### 3-2 Gatsby

* 최신 프레임워크, github octoverse 기준으로 2019년 가장 많이 성장한 오픈소스 프로젝트 TOP10
* 최근 웹 트랜드 기술(react, grabhql) 반영 되어 있음