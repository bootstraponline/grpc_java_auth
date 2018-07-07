#!/bin/bash

set -euxo pipefail

cd ../soseedygrpc
gradle --quiet clean generateProto
cd -

# file name must be api_descriptor.pb or gcloud will error
cp ../soseedygrpc/main.dsc api_descriptor.pb
gcloud --quiet endpoints services deploy api_descriptor.pb api_config.yaml
