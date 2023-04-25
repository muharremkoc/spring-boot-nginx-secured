# spring-boot-nginx-secured


This Project's Goal, Spring-Boot-Nginx-Configuration with SSL Certificated

## Technologies

- Git-OpenSSL(for Certificate Installation)
- Spring Boot
- MySQL
- Nginx
- Jaeger
- Docker


## Installation

### Certification Installation

- First,Create a certificate file and key file with OpenSSL for https secured


![image](https://user-images.githubusercontent.com/80245013/234288424-7e2787df-6c06-4082-839e-9f951e3d1f59.png)


- Copy this files in src/main/resources

![image](https://user-images.githubusercontent.com/80245013/234288524-c71e1d63-8f7d-49bd-95e5-6f041f6138ee.png)


- Open application.properties and configured ssl settings

![image](https://user-images.githubusercontent.com/80245013/234288599-8e6b926b-6d01-4746-be2d-a77c67414162.png)


- Add docker-compose nginx port "443" and volumes this configuration files

![image](https://user-images.githubusercontent.com/80245013/234288685-e51eaf91-8586-4610-9da8-07b9a6b8416e.png)


- Open nginx.conf and add this certificates files path

![image](https://user-images.githubusercontent.com/80245013/234288780-2bc24761-add8-45fb-bed8-5e5e06b982ad.png)



### Jaeger Installation

- Add "JAEGER_AGENT-HOST" in .env file and add docker-compose  spring-boot-services

![image](https://user-images.githubusercontent.com/80245013/234288871-ece460e6-5f61-4b06-a283-5fb6ff0e090b.png)

![image](https://user-images.githubusercontent.com/80245013/234288951-9c71bbd4-31e2-4e5d-ba99-cd680530191e.png)


- Open nginx.conf and Add jaeger location (If your path not optional Only location /{
...})

![image](https://user-images.githubusercontent.com/80245013/234289185-e6dc098a-5a04-4617-b77e-60c9a04dbb70.png)


- Add Jaeger services urls in location

![image](https://user-images.githubusercontent.com/80245013/234289282-98f70c82-c010-49ba-b36c-c2a3644b1ce9.png)


- If you using authentication add this command in nginx.conf for you want location 

```bash
                        auth_basic "Restricted Content";
                        auth_basic_user_file /etc/nginx/.htpasswd;
```
   Visit "https://www.web2generators.com/apache-tools/htpasswd-generator "  For htpasswd generating 
   

![image](https://user-images.githubusercontent.com/80245013/234289629-bed6692c-dedc-41ce-b2d8-a84d6a48afb5.png)

   
   


## Owner

[Muharrem Koç](https://github.com/muharremkoc)
