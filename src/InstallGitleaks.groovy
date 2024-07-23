package org.example.ansible

class InstallGitleaks {
    void call() {
        sh '''
        wget https://github.com/gitleaks/gitleaks/releases/download/v8.18.2/gitleaks_8.18.2_linux_x64.tar.gz
        tar xvzf gitleaks_8.18.2_linux_x64.tar.gz
        '''
    }
}
