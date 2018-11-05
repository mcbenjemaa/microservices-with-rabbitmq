# think-tank-demo-app

# Simple microservices App


 control-service  >> to control the drag. >> port: 8100
 queue-service  >> store the status of the drag over amqp. >> port: 8000
 result-service >> show the result in realtime. >> port: 8400
 config-server >> store all app configuration in centralized repo >> port: 8888
 discovery-service >> discovery service for load balancing >> port: 1800



