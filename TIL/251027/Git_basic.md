# Git 기본학습

## Echo

- echo "hello world" > sample.txt : 덮어쓰기
- echo "hello world >> sample.txt : 이어쓰기

## 브랜치 병합

- merge : 브랜치를 합칠 때, 변경 이력이 남는다.
- rebase : 브랜치를 합칠 때, 이력을 일자로 정리한다. (깔끔)

## 브랜치 충돌 (Conflict)

- merge : 브랜치를 합칠 때, 같은 위치를 서로 다르게 수정하면 충돌 발생 -> 충돌 구간 직접 확인 및 수정 -> merge로 합쳐주기
- rebase : 충돌 구간 직접 확인 및 수정 -> git rebase --continue 후 마지막 main 으로 가서 merge 로 합쳐주기
