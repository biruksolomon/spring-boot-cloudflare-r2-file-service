# Spring Boot – Cloudflare R2 File Service

A secure and scalable file storage service built with **Spring Boot** and **Cloudflare R2 (S3-compatible storage)**.  
This project demonstrates **public vs private file handling**, secure credential management, and **role-based access control**.

---

## ✨ Features

- ☁️ Cloudflare R2 (S3-compatible) integration
- 🔓 Public file access via CDN
- 🔐 Private file access via authenticated API
- 🛡️ Spring Security (role-based access)
- 🔑 Secure credential management (env variables)
- 🚀 Spring Boot 3 + Java 17
- 📦 Clean, production-ready architecture

---

## 🧱 Architecture Overview

Client
├─ Public files → Cloudflare R2 (CDN, no auth)
└─ Private files → Spring Boot API → Cloudflare R2

- **Public bucket**: Direct CDN access
- **Private bucket**: Backend-controlled access only

---

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|--------|
| Java 17 | Runtime |
| Spring Boot 3 | Backend framework |
| Spring Security | Authentication & authorization |
| Cloudflare R2 | Object storage |
| AWS SDK v2 | S3-compatible client |
| Maven | Build tool |

This project uses:
- Environment variables
- External configuration (`application.properties`)

This is for Security reasons.

If credentials are leaked, **rotate them immediately** in Cloudflare R2.

---

## ⚙️ Configuration

### 1️⃣ Environment Variables

```bash
export CF_R2_ACCOUNT_ID=xxxxxxxx
export CF_R2_ACCESS_KEY=xxxxxxxx
export CF_R2_SECRET_KEY=xxxxxxxx

cloudflare.r2.endpoint=https://${CF_R2_ACCOUNT_ID}.r2.cloudflarestorage.com
cloudflare.r2.acess.key=${CF_R2_ACCESS_KEY}
cloudflare.r2.secret.key=${CF_R2_SECRET_KEY}
cloudflare.r2.publicbucket=public-files
cloudflare.r2.privatebucket=private-files
