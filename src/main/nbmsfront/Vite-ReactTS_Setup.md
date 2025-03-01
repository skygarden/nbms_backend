# React App 설치
npm install -g create-react-app

# React 프로젝트 생성(Springboot의 src/main하위에 설치)
npm create vite@latest nbmsfront --template react
  - Select a framework: React
  - Select a variant: TypeScript

# 프로젝트 구조
public/: 정적 파일들을 보관하는 폴더
src/: 소스 코드가 위치하는 폴더
    assets/: 이미지 파일과 같은 정적 자원들을 보관합니다.
    components/: 재사용 가능한 React 컴포넌트들이 위치하며, 공통 컴포넌트와 페이지별(도메인별) 컴포넌트로 구분됩니다.
    pages/: 각각의 페이지 컴포넌트들이 위치하며, 홈, 클래스, 게시판 등 여러 페이지로 나뉩니다.
    routes/: 애플리케이션의 라우팅 설정 파일들이 위치합니다.
    app/: 리덕스 스토어 설정 파일이 위치합니다.
    features/: 리덕스 슬라이스들이 위치합니다.
    utils/: 유틸리티 함수들이 위치합니다. 
            프로젝트 전역에서 사용되는 특정 기능 및 작업을 수행하는데 도움을 주는 함수들이 위치합니다.
    hooks/: 커스텀 훅들이 위치합니다.
    styles/: 스타일 파일들이 위치합니다.
    App.tsx: 주요 React 컴포넌트로, 애플리케이션의 구조를 정의합니다.
    main.tsx: ReactDOM을 사용해 React 애플리케이션을 HTML DOM에 렌더링하는 파일입니다.
package.json: 프로젝트의 메타데이터와 의존성을 관리하는 파일.

# Proxy 설정 (Springboot의 URL를 작성)
package.json 하단에 "proxy": "http://localhost:8080/" 추가

# Springboot의 build.gradle 설정 하단 부분에 내용 추가
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

# Axios 설치 (http 비동기 통신 Library)
npm install axios --save

# TypeScript에서 Node.js 모듈 사용
npm install @types/node

# React Toast Popup 모듈 사용
npm install react-simple-toasts

# CSS 스타일링 (SASS/SCSS)
npm install -D sass

# React Router 모듈 사용
npm install react-router-dom localforage match-sorter sort-by

# Gradle Build (Springboot 프로젝트 폴더에서 진행)
./gradlew build

# Build 파일 실행 (Springboot의 build/libs 폴더) 
java -jar ./nbms_backend-0.0.1-SNAPSHOT.jar 
