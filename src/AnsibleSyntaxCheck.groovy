package org.example.ansible

class AnsibleSyntaxCheck {
    void call(String playbookName) {
        def workspace = env.WORKSPACE
        dir("${workspace}/ansible-playbooks") {
            sh "ansible-playbook --syntax-check ${playbookName}"
        }
    }
}
