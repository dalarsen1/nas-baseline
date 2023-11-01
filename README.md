# Gradle Java Template

![Build Status](https://github.com/mitre-tdp/gradle-java-library-template/actions/workflows/test-and-publish.yml/badge.svg)
<br>
[![Latest Release](https://img.shields.io/badge/release-0.0.1-gre.svg)](https://github.com/mitre-tdp/gradle-java-library-template/gradle.properties)

### Project Overview
This repo represents a set of standard project templates for gradle-based Java projects wishing to eventually deploy in the CRE.

| Branch                                                                                | Summary                                                                               |
|:--------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------|
| [main](https://github.com/mitre-tdp/gradle-java-template)                             | Single-module Java Library - baked in publication                                     |
| [spring](https://github.com/mitre-tdp/gradle-java-template/tree/spring)               | Single-module Java Application (Spring) - baked in Docker image and publication       |
| [camel-kinesis](https://github.com/mitre-tdp/gradle-java-template/tree/camel-kinesis) | Single-module Java Application (Spring/Camel) - baked in Docker image and publication |

Due to how GitHub transfers history when building off a template repo (it doesn't) the process to use a branch that's not main as main (e.g. the spring)
branch is essentially:
```bash
git checkout target-branch
git branch -D main
git checkout -b "main"
git push --set-upstream origin main --force
```
