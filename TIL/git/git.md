# Git

## 새 리포지토리 만들기

### Git 저장소 초기화

```shell
git init
```

- 명령어 실행 시 해당 디렉토리가 Git 관리하에 들어감

## 파일 커밋하기

### 파일 생성
```shell
echo "Hello Git" > hello.txt
```

### 변경 파일 확인
```shell
git status
```

### 파일 스테이지에 올리기
```shell
git add hello.txt
```

### 변경 파일 최종 확인
```shell
git status
```

### 커밋하기
```shell
git commit -m "처음 커밋"
```

- git add: 파일을 커밋 준비 상태(스테이지)로 올림
- git commit: 실제로 변경 내용을 저장

## 리모트 리포지토리에 푸시하기

### 원격 저장소 추가
```shell
git remote add origin <원격 저장소 주소>
```

### 최초 푸시
```shell
git push -u origin main
```

### 이후 푸시
```shell
git push
```

- 원격 저장소(origin)에 최초로 코드를 업로드할 때는 -u 옵션을 붙임
- 이후에는 git push만 입력하면 됨
- 원격 저장소 주소는 Github, Backlog 등에서 생성한 저장소의 클론 주소를 사용

## 리모트 리포지토리 클론하기

```shell
git clone <원격 저장소 주소>
```

- 명령어 실행 시 해당 저장소의 모든 파일과 히스토리가 복제됨
- 클론된 폴더에서 바로 개발 및 파일 관리 가능

## 브랜치 만들기

```shell
git branch <브랜치명>
```

- 현재 브랜치 확인: git branch
- 브랜치 생성만 하면 자동으로 이동하지 않음
- 브랜치 이동하려면: git checkout <브랜치명>

## 브랜치 이동하기

```shell
git checkout <브랜치명>
```

- 현재 작업 중인 브랜치가 변경됨
- 브랜치 목록은 git branch로 확인 가능

## 브랜치 병합하기

```shell
git merge <병합할 브랜치명>
```

- 병합 명령은 현재 브랜치 기준으로 실행됨
- 충돌이 발생하면 직접 수정하고 다시 커밋 필요
- 병합 완료 후 git log로 기록 확인 가능

## 브랜치 삭제하기

```shell
git branch -d <브랜치명>
```

- 병합되지 않은 브랜치 삭제는 -D 옵션 사용: git branch -D <브랜치명>
- 삭제 전에 해당 브랜치가 병합되었는지 확인 권장
- 현재 작업 중인 브랜치는 삭제 불가, 다른 브랜치로 이동 후 삭제

## 병렬로 작업하기

### 브랜치 생성

```shell
git branch issue2  
git branch issue3
```

### 브랜치 전환

```shell
git checkout issue2  
```

### issue2 브랜치에서 파일을 수정하고 커밋

```shell
git add myfile.txt  
git commit -m "commit 설명 추가"
```

### 다시 issue3 브랜치로 이동

```shell
git checkout issue3
```

### issue3 브랜치에서는 파일에 다른 작업을 하고 커밋  

```shell
git add myfile.txt  
git commit -m "pull 설명 추가"
```

- 각 브랜치는 별도의 변경 내역을 가질 수 있음
- 이처럼 여러 브랜치를 만들어 병렬로 다양한 기능 개발이나 작업을 별도로 진행 가능
- 필요한 시점에 병합하면 기능/작업들을 통합할 수 있음

## 병합(merge)에서 충돌 해결하기

### master 브랜치로 이동

```shell
git checkout master
```

### issue2 브랜치 병합 (fast-forward 병합)

```shell
git merge issue2
```

### issue3 브랜치 병합

```shell
git merge issue3
```

- 변경된 같은 파일(myfile.txt)을 서로 다른 브랜치에서 수정했다면 아래처럼 충돌 메시지 출력
- 파일 내부에는 Git이 충돌 부분을 직접 표시해줌

예시(충돌 난 부분):

```shell
<<<<<<< HEAD  
add 변경을 인덱스에 등록  
commit 인덱스 상태 기록  
=======  
pull 원격 저장소의 내용 얻기
>>>>>>> issue3
```

- 직접 파일을 열어 충돌 부분을 원하는 내용으로 고쳐줌

### 수정한 파일을 스테이지에 올림

```shell
git add myfile.txt
```

### 충돌 해결 커밋

```shell
git commit -m "issue3 브랜치 병합"
```

- 충돌 부분을 직접 수정한 뒤 반드시 커밋해야 충돌 해결 완료
- 충돌 수정이 반영된 새로운 머지 커밋이 생성됨
- 이런 병합은 fast-forward가 아닌 "non fast-forward 병합"임

## rebase로 병합하기

### 최근 병합한 커밋을 취소

```shell
git reset --hard HEAD~
```

### 작업 브랜치로 이동

```shell
git checkout issue3
```

### rebase 실행

```shell
git rebase master
```

예시(충돌 난 부분):

```shell
<<<<<<< HEAD  
add 변경을 인덱스에 등록  
commit 인덱스 상태 기록  
=======  
pull 원격 저장소의 내용 얻기
>>>>>>> issue3
```

- 직접 파일을 열어 충돌 부분을 원하는 내용으로 고쳐줌

### 파일을 직접 수정 후 rebase 진행

```shell
git add myfile.txt  
git rebase --continue
```

### rebase를 중단하려면

```shell
git rebase --abort
```

### master 브랜치로 돌아가서 병합

```shell
git checkout master  
git merge issue3
```

- rebase는 커밋 이력을 하나로 직관적으로 정리할 수 있는 병합 방식
- 작업 브랜치(issue3)를 master 브랜치에 rebase해서 커밋 히스토리가 일직선이 되도록 함
- rebase를 사용하면 fast-forward 병합이 되어 커밋 분기 없이 이력이 정리됨
