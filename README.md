# 프론트엔드 참고

### 풀리퀘스트 하는 법

1. 레포지토리를 포크한다.
2. 포크한 레포지토리를 로컬로 클론한다.
3. `git remote -v`로 리모트 레포지토리를 확인한다.
4. origin 밖에 없을 경우 팀 레포지토리를 추가하여야 한다.
5. `git remote add upstream https://github.com/codestates-seb/seb43_main_020.git`로 팀 레포지토리를 리모트 레포지토리에 추가한다.
6. `git remote -v`로 팀 레포지토리가 리모트 레포지토리로 지정되었는지 확인한다.
7. 팀 레포지토리 frontend 브랜치의 변경 사항을 가져오기 `git pull upstream frontend`를 입력한다.
8. 충돌하는 부분이 있다면 수동으로 병합한다.
9. 병합 후 원격 저장소에 push 한다.
10. 원격 저장소에서 pull request를 생성한다.

### 색상

- 파란색 색상코드: #408EF1
- 구분선 색상코드: #DCDCDC
