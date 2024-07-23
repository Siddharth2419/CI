package org.example.ansible

class Checkout {
    void call(String url, String creds, String branch) {
        def workspace = env.WORKSPACE
        dir(workspace) {
            withCredentials([string(credentialsId: creds, variable: 'GITHUB_TOKEN')]) {
                sh "git clone --branch ${branch} https://$GITHUB_TOKEN@${url}"
            }
        }
    }
}
