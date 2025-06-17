# ETAP 1 - Budowanie aplikacji Amgular
FROM node:20 as build
WORKDIR /usr/local/app
COPY ./ /usr/locla/app
RUN npm install
RUN npm run build

# ETAP 2: Serwowanie plikow przez Nginx
FROM nginx:latest
#Skopiuj zbudowane pliki z etapu 1
COPY --from=build /usr/local/app/dist/frontend /usr/share/nginx/html
# Skopiuj konfigurację Nginx (stworzymy ją za chwilę)
COPY nginx.conf /etc/nginx/conf.d/default.conf
