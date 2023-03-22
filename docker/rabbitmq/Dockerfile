FROM rabbitmq:3-management-alpine
EXPOSE 61613 15672 15674 5672 15670 15692
COPY rabbitmq.conf /etc/rabbitmq/rabbitmq.conf
RUN rabbitmq-plugins enable rabbitmq_stomp
RUN rabbitmq-plugins enable rabbitmq_web_stomp