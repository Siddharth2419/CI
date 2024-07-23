import org.example.ansible.Checkout
import org.example.ansible.Gitleaks
import org.example.ansible.InstallGitleaks
import org.example.ansible.AnsibleSyntaxCheck
import org.example.ansible.LintCheck

def call(Map params) {
    pipeline {
        agent any

        environment {
            GITHUB_TOKEN = credentials('github') // Ensure this matches your Jenkins credential ID
            LC_ALL = 'en_US.UTF-8'
            LANG = 'en_US.UTF-8'
        }

        stages {
            stage('Clone Repository') {
                steps {
                    script {
                        new Checkout().call('https://github.com/Siddharth2419/CI.git', 'github-token', 'main')
                    }
                }
            }

            stage('Download and Install Gitleaks') {
                steps {
                    script {
                        new InstallGitleaks().call()
                    }
                }
            }

            stage('Gitleaks Scan') {
                steps {
                    script {
                        new Gitleaks().call()
                    }
                }
            }

            stage('Ansible Syntax Check') {
                steps {
                    script {
                        new AnsibleSyntaxCheck().call(params.PLAYBOOK_NAME)
                    }
                }
            }

            stage('Build Env and Run Lint Check') {
                steps {
                    script {
                        new LintCheck().call(params.PLAYBOOK_NAME)
                    }
                }
            }
        }

        post {
            success {
                archiveArtifacts artifacts: '**/CredScanReport, **/lint_report.txt'
                cleanWs()
            }
            failure {
                archiveArtifacts artifacts: '**/CredScanReport, **/lint_report.txt'
                cleanWs()
            }
        }
    }
}
