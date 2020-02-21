cd integratedCartService

 
 echo 'I am in here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'

#Build docker image

docker build -f Dockerfile-cloud -t 961905255215.dkr.ecr.us-east-1.amazonaws.com/ihs-partner-sessions:$Ver .

 

# #Login to ECR

# $(/bin/aws ecr get-login | sed -e 's/-e none //g')

 

# #Push image to ECR

# /bin/docker push 961905255215.dkr.ecr.us-east-1.amazonaws.com/ihs-partner-sessions:$Ver

 

# #Build ECS Clusters

# /bin/aws ecs create-cluster --cluster-name dev-on-tech

 

# #Setup ECS

# /usr/local/bin/ecs-cli configure profile \

# --profile-name shs \

# --access-key $aws_access_key_id \

# --secret-key $aws_secret_access_key

 

# # Configure ECS

# /usr/local/bin/ecs-cli configure \

# --cluster dev-on-tech \

# --region us-east-1 \

# --default-launch-type FARGATE \

# --config-name dev-integrated-cart

 

# # Create docker-compose file

# /bin/cat <<EOM > docker-compose.integrated-cart.yml

# version: '3'

# services:

#   integrated-cart:

#     image: 961905255215.dkr.ecr.us-east-1.amazonaws.com/ihs-partner-sessions:$Ver

# #    env_file: .env

#     ports:

#       - "3000:3000"

#     logging:

#       driver: "awslogs"

#       options:

#         awslogs-region: "us-east-1"

#         awslogs-group: "dev-integrated-cart"

#         awslogs-stream-prefix: "integrated-cart"

# EOM

 

# #Copy ECS Params File

# cp -p /var/lib/jenkins/workspace/TestEnv/UpdateECSParams-develop/ecs-params.yml ecs-params.yml

 

# # commands for deleting service if needed

# #/bin/aws ecs delete-service \

# #--cluster dev-on-tech \

# #--service integrated-cart \

# #--force

 

# #Create services

# /usr/local/bin/ecs-cli compose \

# --ecs-profile shs \

# --cluster-config dev-integrated-cart \

# --file docker-compose.integrated-cart.yml \

# --ecs-params ecs-params.yml \

# --project-name integrated-cart \

# service up \

# --create-log-groups \

# --container-name integrated-cart \

# --container-port 3000 \

# --target-group-arn $(/usr/bin/aws elbv2 describe-target-groups --names dev-partner-target --region us-east-1 | /usr/bin/jq -r .TargetGroups[0].TargetGroupArn)