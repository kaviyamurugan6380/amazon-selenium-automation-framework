# Amazon E2E Test Automation Framework

Automated end-to-end test of the core Amazon.in shopping workflow, built with Selenium WebDriver, Java, TestNG and Maven using the Page Object Model.

## Demo video
[Watch the test run (3 min 22 sec)](PASTE_YOUR_VIDEO_LINK_HERE)

## Workflow covered
Sign in > Search product > Product listing > Apply rating filter > Open product > Add to cart > Cart > Checkout (stops at the payment page) > Sign out

The test never places an order or enters payment details.

## Tech stack and why
| Tool | Why it is used |
|---|---|
| Java 17 | Core language, object-oriented design |
| Selenium WebDriver 4 | Browser automation (Chrome) |
| TestNG | Test annotations, assertions, suite run via testng.xml |
| Maven | Dependency management and running tests with `mvn test` |
| Page Object Model | One class per page, so locators and actions stay separate from test logic |

## Framework structure
- `com.automation.base`: DriverFactory, BaseTest (browser setup and teardown)
- `com.automation.pages`: BasePage, HomePage, LoginPage, SearchResultsPage, ProductPage, CartPage, CheckoutPage
- `com.automation.utils`: ConfigReader (reads config.properties)
- `src/main/resources/config.properties`: URL, credentials, search term, wait time
- `com.automation.tests`: AmazonE2ETest
- `testng.xml`: test suite
- `pom.xml`: dependencies

## How to run
1. Install JDK 17 and Chrome.
2. Add your own Amazon login in `src/main/resources/config.properties` (username and password). Do not commit it.
3. Run `mvn test`, or in Eclipse right-click the project > Run As > Maven test.

## Notes
- If Amazon shows an OTP or CAPTCHA at login, complete it manually in the browser.
- Amazon changes its page structure often, so locators may need updates.
- Explicit waits are used for stability.

## Author
Kaviya
