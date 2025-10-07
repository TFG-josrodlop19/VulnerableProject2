# VulnerableProject2

This is a sample Java project that contains a known vulnerability for testing Autofuzz. 

## Vulnerability Details

The project includes dom4j version 2..1.1, which is known to have a critical security vulnerability: CVE-2020-10683. This vulnerability allows for XML External Entity (XXE) attacks, which can lead to unauthorized access to sensitive data.

## Purpose
The purpose of this project is to provide a controlled environment for testing and demonstrating the Autofuzz tool's capabilities in identifying and exploiting vulnerabilities in Java applications.