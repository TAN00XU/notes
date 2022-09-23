# 一、版本依赖

https://start.spring.io/actuator/info

获取JSON，查看版本依赖

```json
{
	"git": {
		"branch": "8f69147fc461cc0e0e5318ff711963ca58b84c3c",
		"commit": {
			"id": "8f69147",
			"time": "2022-09-21T11:26:04Z"
		}
	},
	"build": {
		"version": "0.0.1-SNAPSHOT",
		"artifact": "start-site",
		"versions": {
			"spring-boot": "2.7.3",
			"initializr": "0.13.0-SNAPSHOT"
		},
		"name": "start.spring.io website",
		"time": "2022-09-21T11:29:33.497Z",
		"group": "io.spring.start"
	},
	"bom-ranges": {
		"codecentric-spring-boot-admin": {
			"2.4.3": "Spring Boot >=2.3.0.M1 and <2.5.0-M1",
			"2.5.6": "Spring Boot >=2.5.0.M1 and <2.6.0-M1",
			"2.6.8": "Spring Boot >=2.6.0.M1 and <2.7.0-M1",
			"2.7.4": "Spring Boot >=2.7.0.M1 and <3.0.0-M1",
			"3.0.0-M4": "Spring Boot >=3.0.0-M1 and <3.1.0-M1"
		},
		"solace-spring-boot": {
			"1.1.0": "Spring Boot >=2.3.0.M1 and <2.6.0-M1",
			"1.2.1": "Spring Boot >=2.6.0.M1 and <2.7.0-M1"
		},
		"solace-spring-cloud": {
			"1.1.1": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
			"2.1.0": "Spring Boot >=2.4.0.M1 and <2.6.0-M1",
			"2.3.0": "Spring Boot >=2.6.0.M1 and <2.7.0-M1"
		},
		"spring-cloud": {
			"Hoxton.SR12": "Spring Boot >=2.2.0.RELEASE and <2.4.0.M1",
			"2020.0.6": "Spring Boot >=2.4.0.M1 and <2.6.0-M1",
			"2021.0.0-M1": "Spring Boot >=2.6.0-M1 and <2.6.0-M3",
			"2021.0.0-M3": "Spring Boot >=2.6.0-M3 and <2.6.0-RC1",
			"2021.0.0-RC1": "Spring Boot >=2.6.0-RC1 and <2.6.1",
			"2021.0.4": "Spring Boot >=2.6.1 and <3.0.0-M1",
			"2022.0.0-M1": "Spring Boot >=3.0.0-M1 and <3.0.0-M2",
			"2022.0.0-M2": "Spring Boot >=3.0.0-M2 and <3.0.0-M3",
			"2022.0.0-M3": "Spring Boot >=3.0.0-M3 and <3.0.0-M4",
			"2022.0.0-M4": "Spring Boot >=3.0.0-M4 and <3.1.0-M1"
		},
		"spring-cloud-azure": {
			"4.3.0": "Spring Boot >=2.5.0.M1 and <3.0.0-M1"
		},
		"spring-cloud-gcp": {
			"2.0.11": "Spring Boot >=2.4.0-M1 and <2.6.0-M1",
			"3.3.0": "Spring Boot >=2.6.0-M1 and <2.7.0-M1"
		},
		"spring-cloud-services": {
			"2.3.0.RELEASE": "Spring Boot >=2.3.0.RELEASE and <2.4.0-M1",
			"2.4.1": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
			"3.3.0": "Spring Boot >=2.5.0-M1 and <2.6.0-M1",
			"3.4.0": "Spring Boot >=2.6.0-M1 and <2.7.0-M1",
			"3.5.0": "Spring Boot >=2.7.0-M1 and <3.0.0-M1"
		},
		"spring-geode": {
			"1.3.12.RELEASE": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
			"1.4.13": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
			"1.5.14": "Spring Boot >=2.5.0-M1 and <2.6.0-M1",
			"1.6.11": "Spring Boot >=2.6.0-M1 and <2.7.0-M1",
			"1.7.3": "Spring Boot >=2.7.0-M1 and <3.0.0-M1",
			"2.0.0-M4": "Spring Boot >=3.0.0-M1 and <3.1.0-M1"
		},
		"spring-shell": {
			"2.1.1": "Spring Boot >=2.7.0 and <3.0.0-M1"
		},
		"vaadin": {
			"14.8.17": "Spring Boot >=2.1.0.RELEASE and <2.6.0-M1",
			"23.2.1": "Spring Boot >=2.6.0-M1 and <2.8.0-M1"
		},
		"wavefront": {
			"2.0.2": "Spring Boot >=2.1.0.RELEASE and <2.4.0-M1",
			"2.1.1": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
			"2.2.2": "Spring Boot >=2.5.0-M1 and <2.7.0-M1",
			"2.3.0": "Spring Boot >=2.7.0-M1 and <3.0.0-M1"
		}
	},
	"dependency-ranges": {
		"native": {
			"0.9.0": "Spring Boot >=2.4.3 and <2.4.4",
			"0.9.1": "Spring Boot >=2.4.4 and <2.4.5",
			"0.9.2": "Spring Boot >=2.4.5 and <2.5.0-M1",
			"0.10.0": "Spring Boot >=2.5.0-M1 and <2.5.2",
			"0.10.1": "Spring Boot >=2.5.2 and <2.5.3",
			"0.10.2": "Spring Boot >=2.5.3 and <2.5.4",
			"0.10.3": "Spring Boot >=2.5.4 and <2.5.5",
			"0.10.4": "Spring Boot >=2.5.5 and <2.5.6",
			"0.10.5": "Spring Boot >=2.5.6 and <2.5.9",
			"0.10.6": "Spring Boot >=2.5.9 and <2.6.0-M1",
			"0.11.0-M1": "Spring Boot >=2.6.0-M1 and <2.6.0-RC1",
			"0.11.0-M2": "Spring Boot >=2.6.0-RC1 and <2.6.0",
			"0.11.0-RC1": "Spring Boot >=2.6.0 and <2.6.1",
			"0.11.0": "Spring Boot >=2.6.1 and <2.6.2",
			"0.11.1": "Spring Boot >=2.6.2 and <2.6.3",
			"0.11.2": "Spring Boot >=2.6.3 and <2.6.4",
			"0.11.3": "Spring Boot >=2.6.4 and <2.6.6",
			"0.11.5": "Spring Boot >=2.6.6 and <2.7.0-M1",
			"0.12.0": "Spring Boot >=2.7.0-M1 and <2.7.1",
			"0.12.1": "Spring Boot >=2.7.1 and <3.0.0-M1"
		},
		"okta": {
			"1.4.0": "Spring Boot >=2.2.0.RELEASE and <2.4.0-M1",
			"1.5.1": "Spring Boot >=2.4.0-M1 and <2.4.1",
			"2.0.1": "Spring Boot >=2.4.1 and <2.5.0-M1",
			"2.1.6": "Spring Boot >=2.5.0-M1 and <3.0.0-M1"
		},
		"mybatis": {
			"2.1.4": "Spring Boot >=2.1.0.RELEASE and <2.5.0-M1",
			"2.2.2": "Spring Boot >=2.5.0-M1"
		},
		"camel": {
			"3.5.0": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
			"3.10.0": "Spring Boot >=2.4.0.M1 and <2.5.0-M1",
			"3.13.0": "Spring Boot >=2.5.0.M1 and <2.6.0-M1",
			"3.17.0": "Spring Boot >=2.6.0.M1 and <2.7.0-M1",
			"3.18.1": "Spring Boot >=2.7.0.M1 and <3.0.0-M1"
		},
		"picocli": {
			"4.6.3": "Spring Boot >=2.4.0.RELEASE and <3.0.0-M1"
		},
		"open-service-broker": {
			"3.2.0": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
			"3.3.1": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
			"3.4.1": "Spring Boot >=2.5.0-M1 and <2.6.0-M1",
			"3.5.0": "Spring Boot >=2.6.0-M1 and <2.7.0-M1"
		}
	}
}
```



