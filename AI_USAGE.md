# How I used AI in this project

I used Claude as a coding assistant. I reviewed, ran and fixed everything myself.

| Stage | How AI helped | What I did |
|---|---|---|
| Planning | Helped turn the assignment into a workflow and a one-day plan | Chose the scope: login to checkout, no payment |
| Framework design | Suggested the POM package structure and the Maven setup | Built the project in Eclipse and kept to my own stack (Selenium, Java, TestNG, Maven) |
| Code | Generated first versions of the page classes and the E2E test | Created each class, ran the suite, checked the results |
| Debugging | Read my Maven console logs and suggested fixes for failures | Re-ran after each change and fixed locator and timing issues (login field, product link, add to cart, cart check, checkout check) |
| Documentation | Helped draft this README | Edited it to match what I built |

## Key lesson
AI output was a starting point. The real Amazon pages behaved differently from the first code, so each failure was fixed by reading the console log and re-running.