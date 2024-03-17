# Deployment Key Checkpoints

## Deploy the service in Kubernetes

```bash
kubectl apply -f demo/config.yaml
kubectl apply -f demo/pvc.yaml
kubectl apply -f demo/postgres-single.yaml
kubectl apply -f demo/service.yaml
```

## Inject the Istio sidecar


## Enable kiali and view the service graph


## About the docker compose tool and PGAdmin

PGAdmin is a tool that allows you to manage your PostgreSQL database. It is a web-based tool that allows you to create, edit, and delete databases, tables, and rows.

The docker-compose script can help you to run the PGAdmin tool and PostgreSQL database in a single command.

To run it, type the following command in your terminal:

```bash
docker compose up
```

Since the PGAdmin tool is running in a docker container, you need to configure the server name properly to connect to the PostgreSQL database:
- If your PostgreSQL database is running in docker container, the configured server name in PGAdmin should be `postgres`.
- If your PostgreSQL database is running in host machine, the configured server name in PGAdmin should be `host.docker.internal`.