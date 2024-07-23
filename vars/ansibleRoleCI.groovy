// ansibleLint.groovy
def ansibleLint(String path) {
    org.example.ansible.AnsibleLint.call(path)
}

// ansibleSyntaxCheck.groovy
def ansibleSyntaxCheck(String path) {
    org.example.ansible.AnsibleLint.call(path)
}

// dryRun.groovy
def dryRun(String path) {
    org.example.ansible.DryRun.call(path)
}

// credScanning.groovy
def credScanning() {
    org.example.ansible.DryRun.call('')
}
