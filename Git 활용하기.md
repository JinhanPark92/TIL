# Git 활용하기

## 1. 다른 디바이스에서 서로 상호 호환하기

* 기존 디바이스에서 마지막 commit 및 push를 하여 원격 저장소에 최신화를 이룬다.
* 새로운 디바이스에서 git clone <원격 저장소 주소>로 목록 복제하기
* 새로운 디바이스에서 수정된 내용을 기존 디바이스에서 이끌어오기 위해선 작업 시작 전, git pull origin master를 진행

> 작업을 완료한 이후에는 항상 push
>
> 작업을 시작하기 전에는 항상 pull

## 2. 충돌 상황

* 만양게 원격저장소의 이력과 로컬 저장소의 이력이 다른 경우에는 아래의 메시지가 발생한다.

```bash
$ git push origin master
To https://github.com/edutak/database.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/edutak/database.git'
# 원격저장소의 작업 내용(work - commit)과 로컬 내용이 다르다.
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
# 원격 저장소 변경사항(changes)을 통합하고 다시 push 해라.
# 예) git pull ...
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

* 이 메시지를 보게 된다면, 로컬에서 git log.원격저장소의 커밋 이력들을 확인하고 다른 부분을 체크하자!!!

```bash
$ git pull origin master
```

통합 후,

```bash
$ git push origin master
```

