

FROM frankescobar/allure-docker-service as build-step-2

WORKDIR /app

COPY . /app

RUN allure generate allure-results --clean -o html

FROM nginx:latest

RUN rm -rf /usr/share/nginx/html/*

COPY --from=build-step-2 /app/html /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]


