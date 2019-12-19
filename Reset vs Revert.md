# Reset vs Revert

## Reset

> 공개된 저장소(원격 저장소)에 push 된 이력은 절대 reset 하지 않는다.

```
$ git reset {해시코드}
```

- 기본 (`--mixed`) : 이후 변경 사항을 WD에 유지 시켜줌.
- `--hard` : 이후 변경 사항이 모두 삭제됨. **주의**
- `--soft` : 지금 작업하고 있는 내용(WD) 및 변경사항을 WD에 유지 시켜줌.

## Revert

> 해당 커밋으로 되돌렸다라는 이력(revert commit)을 남긴다.

```
$ git revert {해시코드}
```

- vim -> 커밋 메시지 작성

