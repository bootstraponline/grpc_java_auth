# gRPC deployment

Mindmap overview:

* Kubernetes cluster JSON is used by create_clusters.jar to create the cluster
* kubectl is used to deploy into the cluster via deployment_manifest.yaml
* Java code is compiled into a Dockerfile and uploaded to Google Container Registry
* protobuf description is uploaded to Google Cloud Endpoints
* SSL certs are generated via cloudflare SSL

---


* Deploy protobuf to cloud endpoints
  * ./gcloud_endpoints.sh
* Create cluster via cluster.json and create_cluster.jar
* Generate SSL certificates
  * ./cfssl/cfssl.sh
* Build Docker image and push to registery
  * ./gc_docker_registry.sh
* Get credentials for cluster
  * gcloud container clusters list
  * gcloud container clusters get-credentials cluster-1 --zone us-central1-a
* Upload secret to cluster for load balancer TLS termination
 * ./create_secret.sh
* Deploy cluster

```
kubectl delete -f deployment_manifest.yaml
kubectl create -f deployment_manifest.yaml

kubectl get service
kubectl get pod
```

* Debug via logs as necessary

kubectl logs esp-grpc-passthrough-745978f8d7-cjrld -c esp
kubectl logs esp-grpc-passthrough-745978f8d7-cjrld -c termination

* Optionally use bash shell to investigate issues

kubectl exec -it esp-grpc-5bdcd74d47-nbr45 -- /bin/bash

* Update an existing deployment

```
kubectl edit -f deployment_manifest.yaml
kubectl rollout status deployment/esp-grpc-passthrough
kubectl set image deployment/esp-grpc-passthrough passthrough=gcr.io/delta-essence-114723/ssl_passthrough:latest
```

- https://kubernetes.io/docs/concepts/workloads/controllers/deployment/#updating-a-deployment