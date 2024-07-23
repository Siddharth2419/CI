package org.example.ansible

class LintCheck {
    void call(String playbookName) {
        def workspace = env.WORKSPACE
        dir("${workspace}/ansible-playbooks") {
            sh '''
            python3 -m venv venv
            . venv/bin/activate
            pip install ansible-lint
            ansible-lint ${playbookName} -f full > lint_report.txt
            '''
        }
    }
}
