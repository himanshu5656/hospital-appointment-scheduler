# 🏥 Smart Hospital Appointment Scheduler

A full-stack Hospital Appointment Management System built with Java Spring Boot and MySQL.

## 🚀 Live Demo
> Coming soon

## ✨ Features
- 🔐 Patient Login & Registration
- 👨‍⚕️ Browse 15+ Doctors by Specialization
- 📅 Real-time Slot Booking
- ❌ Appointment Cancellation
- ⚡ Auto Waitlist Assignment
- 📋 My Appointments Dashboard

## 🛠️ Tech Stack
| Layer | Technology |
|-------|-----------|
| Backend | Java 24, Spring Boot 3.5 |
| Database | MySQL 8.0 |
| ORM | Hibernate / JPA |
| Frontend | HTML, CSS, JavaScript |
| Build Tool | Maven |

## 📡 API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register patient |
| POST | `/api/auth/login` | Login |
| GET | `/api/doctors` | Get all doctors |
| GET | `/api/slots/doctor/{id}` | Get available slots |
| POST | `/api/appointments/book` | Book appointment |
| DELETE | `/api/appointments/cancel/{id}` | Cancel appointment |
| GET | `/api/appointments/my/{id}` | My appointments |

## ⚙️ Setup Instructions
1. Clone the repo
2. Create MySQL database: `hospital_db`
3. Update `application.properties` with your MySQL password
4. Run: `mvn spring-boot:run`
5. Open: `http://localhost:8080`

## 👨‍💻 Author
**Himanshu Singh** | B.Tech IT | Galgotias College of Engineering and Technology
