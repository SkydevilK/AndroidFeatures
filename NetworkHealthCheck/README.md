## Network Health Check

### 목적

- 사내 안드로이드 프로젝트에서 Server 상태를 확인하기 위해 만듬

### 기능
- 특정 주소에 1분마다 Request를 보내고 Response를 받음.
- 1초 이상 딜레이가 있을 경우 Server 장애로 판단
- 결과는 Linear Graph로 보여주고 텍스트 파일로 저장.
