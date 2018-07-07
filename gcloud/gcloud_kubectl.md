# Google Cloud Platform - Kubernetes Engine

gRPC deployment instructions for running on Kubernetes Engine

TODO: endpoints api_descriptor/api_config

## Create a cluster

- Use web UI then click "Equivalent REST" https://console.cloud.google.com/kubernetes/list?project=PROJECT_ID
- Save output to cluster.json
- Deploy json via REST API

## Generate SSL keys

./cfssl/cfssl.sh

## Push gRPC jar to docker registry

./gc_docker_registry.sh

## Deploy for ESP SSL termination

gRPC client -> ESP -> gRPC server

* client to ESP is SSL
* ESSP to server is plaintext

```
gcloud container clusters list
gcloud container clusters get-credentials cluster-1 --zone us-central1-a

./create_secret.sh

kubectl delete -f ssl_termination.yaml
kubectl create -f ssl_termination.yaml

kubectl get service
kubectl get pod

kubectl logs esp-grpc-5bdcd74d47-nbr45 -c esp
kubectl logs esp-grpc-5bdcd74d47-nbr45 -c soseedy
```

## Deploy for ESP SSL passthrough

gRPC client -> ESP -> gRPC server

* client to ESP is SSL
* ESSP to server is SSL

```
gcloud container clusters list
gcloud container clusters get-credentials cluster-1 --zone us-central1-a

./create_secret.sh

kubectl delete -f ssl_termination.yaml
kubectl create -f ssl_termination.yaml

kubectl get service
kubectl get pod

kubectl logs esp-grpc-5bdcd74d47-nbr45 -c esp
kubectl logs esp-grpc-5bdcd74d47-nbr45 -c soseedy
```

## Notes

- Run shell script
`kubectl exec -it esp-grpc-5bdcd74d47-nbr45 -- /bin/bash`
