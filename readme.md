# Life Line – Backend

_A simple way to reflect on your days and see the bigger picture of your life._

**Life Line** is a personal journaling and well-being tracker. Each day, users can log a short description of what happened and give the day a **score from 1 to 10**. These daily entries are saved and displayed as part of the user’s **lifeline** — a timeline that visually represents their journey over time.

The backend, built with **Java Spring Boot**, powers the core functionality of the platform, making it possible for users to:

- **Log daily entries** – Write a short description and rate the day from 1 (bad) to 10 (excellent).
- **Visualize days on a lifeline** – Each day is shown as a dot on a horizontal timeline.
- **Color-coded insights** – Dots are automatically colored based on the day’s score:
  - 🟢 Green for good days
  - 🟡 Yellow for average days
  - 🔴 Red for bad days
- **Track progress over time** – Alongside the lifeline, the app shows average scores for:
  - The last 7 days
  - The last 30 days
  - Year-to-date

The project is designed to help users **reflect on their lives, identify patterns, and celebrate progress**. By turning daily reflections into a simple visual journey, _Life Line_ makes personal growth and self-awareness both accessible and meaningful.

This repository contains the **backend component** of the application, which manages data storage, timeline logic, and calculations for averages and day scores.
