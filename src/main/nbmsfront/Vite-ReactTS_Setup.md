# React 설치
```markdown
1. React App 설치
	npm install -g create-react-app

2. React 프로젝트 생성(Springboot의 src/main하위에 설치)
	npm create vite@latest nbmsfront --template react
	- Select a framework: React
	- Select a variant: TypeScript

3. Axios 설치 (http 비동기 통신 Library)
	npm install axios --save

4. TypeScript에서 Node.js 모듈 사용
	npm install @types/node

5. React Toast Popup 모듈 사용
	npm install react-simple-toasts

6. CSS 스타일링 (SASS/SCSS)
	npm install -D sass

7. React Router 모듈 사용
	npm install react-router-dom localforage match-sorter sort-by
```
# 프로젝트 구조
### 정적 파일 관리 (public/)
- public/ 					: 정적 파일이 위치하는 폴더로, 빌드 없이 바로 접근할 수 있습니다.
- public/assets/ 				: 정적 리소스를 관리합니다.
- public/assets/background/ 	: 배경 이미지.
- public/assets/icons/ 		: 아이콘 파일.
- public/assets/images/ 		: 일반 이미지 파일.
- public/assets/logo/ 		: 프로젝트 로고 파일.

### 소스 코드 관리 (src/)
- src/ 			: 프로젝트의 주요 소스 코드가 위치하는 폴더입니다.
- src/components/ : 재사용 가능한 UI 컴포넌트. 공통 컴포넌트와 페이지별(도메인별) 컴포넌트로 구분됨.
- src/constants/	: 공통 상수 모음.
- src/contexts/ 	: Context API를 활용한 전역 상태 관리.
- src/hooks/ 		: 커스텀 훅(Custom Hooks) 모음.
- src/layouts/ 	: 공통 레이아웃(헤더, 풋터, 사이드바 등).
- src/pages/ 		: 개별 페이지 컴포넌트. 홈, 클래스, 게시판 등 여러 페이지로 나뉨
- src/routes/ 	: 라우팅 설정.
- src/sections/ 	: 특정 페이지의 섹션별 코드.
- src/services/ 	: API 호출 및 외부 서비스 연동.
- src/stores/ 	: 전역 상태 관리 라이브러리 관련 모음.(리덕스 스토어 설정 파일)
- src/theme/ 		: 테마 및 스타일 관련 파일.
- src/types/		: 각종 타입 관련 모음.
- src/utils/ 		: 공통 유틸리티 함수. 
					  프로젝트 전역에서 사용되는 특정 기능 및 작업을 수행하는데 도움을 주는 함수들이 위치
- src/App.tsx		: 주요 React 컴포넌트로, 애플리케이션의 구조를 정의합니다.
- src/main.tsx	: ReactDOM을 사용해 React 애플리케이션을 HTML DOM에 렌더링하는 파일입니다.
- src/package.json: 프로젝트의 메타데이터와 의존성을 관리하는 파일.

### Proxy 설정 (Springboot의 URL를 작성)
package.json 하단에 "proxy": "http://localhost:8080/" 추가

### Springboot의 build.gradle 설정 하단 부분에 내용 추가
```gradle
def reactFrontDir = "$projectDir/src/main/reactfront"

sourceSets {
	main {
		resources { srcDirs = ["$projectDir/src/main/resources"]
		}
	}
}

processResources { dependsOn "copyReactBuildFiles" }

task installReact(type: Exec) {
	workingDir "$reactFrontDir"
	inputs.dir "$reactFrontDir"
	group = BasePlugin.BUILD_GROUP
	if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
		commandLine "npm.cmd", "audit", "fix"
		commandLine 'npm.cmd', 'install' }
	else {
		commandLine "npm", "audit", "fix" commandLine 'npm', 'install'
	}
}

task buildReact(type: Exec) {
	dependsOn "installReact"
	workingDir "$reactFrontDir"
	inputs.dir "$reactFrontDir"
	group = BasePlugin.BUILD_GROUP
	if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
		commandLine "npm.cmd", "run-script", "build"
	} else {
		commandLine "npm", "run-script", "build"
	}
}

task copyReactBuildFiles(type: Copy) {
	dependsOn "buildReact"
	from "$reactFrontDir/dist"
	into "$projectDir/src/main/resources/static"
}
```


# SpringBoot + React 배포
### Gradle Build (Springboot 프로젝트 폴더에서 진행)
./gradlew build

### Build 파일 실행 (Springboot의 build/libs 폴더) 
java -jar ./nbms_backend-0.0.1-SNAPSHOT.jar 
