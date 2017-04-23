# BlockchainApp

- IO-Homework 결과물 Android Application 입니다

## Usage
- 블록체인의 정보를 추출하는 기능에는 다음 3가지가 있습니다
>+ 트랜젝션의 수, 평균 값, 평균 수수료, 평균 크기를 출력하는 "SEARCH"
>+ 트랜젝션의 INPUT 의 해당하는 정보를 출력하는 "INPUT"
>+ 트랜젝션의 OUTPUT 의 해당하는 정보를 출력하는 "OUTPUT"

## Code

1. Library
- Volley
>+ 블록체인 API의 웹URL으로부터 문자열형태의 스트림기반 JSON 데이터 전송 받습니다
>+ https://github.com/google/volley
- GSON
>+ JSON parsing을 위해 블록체인 트랜젝션의 정보를 추출합니다
>+ https://github.com/google/gson

2. Model
- BlockchainData Class
>+ 블록체인 API(https://blockchain.info/block-index/{blockhash}?format=json)를 통해 JSON 데이터 구조를 확인 후 숙제의 요구사항을 분석할 수 있었습니다
>+ AndroidStudio 플러그인 GsonFormat 사용하여 모델 클래스 생성했습니다
>+ https://plugins.jetbrains.com/plugin/7654-gsonformat
- 현재는 단일 모델 클래스만 생성하였지만, 차후 모듈화를 위한 트랜젝션 분류 계획이 있습니다

3. Methods in MainActivity
- requestJsonObject
>+ Volley의 StringRequest()를 통해 JSON 데이터를 받고 GSON의 Gson.fromJson() 활용하여 파싱합니다
- showResult
>+ 블록체인의 정보 추출 기능 3가지에 따라 다르게 출력합니다

## Homework Epilogue
- 이번 숙제를 진행하면서 안드로이드 코드 구현에 대한 부족함을 많이 느꼈습니다. 특히 이번 문제의 핵심이었던 Web URL 기반의 JSON 파싱 부분에 대한 경험이 많지 않았던 것이 시간이 오래 소요되었습니다.
 하지만, 블록체인에 대한 이해와 그동안 묵혀두었던 안드로이드스튜디오에서의 작업은 개인적으로 앞으로 해야할 일과 개선해야할 점을 찾을 수 있었던 소중한 과제라고 생각합니다.
- 이 프로젝트는 여기서 멈추지 않습니다. 여기 GitHub에서 지속적인 개선으로 추후 정식으로 플레이스토어를 통해 출시할 계획입니다.