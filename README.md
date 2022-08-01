# chat-app

Ung dung chat realtime.

Minh lam de hoc WebSocket va tich hop voi Spring Boot. Co ca phan social login (Google, Facebook).

## Tech

- Java 11 + Spring Boot
- WebSocket (STOMP)
- Vue.js (frontend)
- MySQL
- Spring Security + JWT + OAuth2

## Tinh nang

- Chat realtime giua cac user
- Dang nhap bang Google/Facebook
- Hien thi danh sach nguoi dang online
- Gui tin nhan van ban

## Cach chay

Backend:
```bash
mvn spring-boot:run
```

Frontend:
```bash
cd jwt-social-login-client
npm install
npm run serve
```

## TODO

- [ ] Them gui hinh anh
- [ ] Them group chat
- [ ] Notification khi co tin nhan moi
