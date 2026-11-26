# DevOps and Cloud Computing Lab Assessment — SET B (Question 2)
## Online Feedback Form Application & CI/CD Pipeline

This project satisfies all requirements for **Question 2 – Online Feedback Form** from the DevOps and Cloud Computing Lab practical examination.

---

### Project Architecture & Folder Layout
```text
Devops and Cloud Computing ext practical/
│
├── .github/
│   └── workflows/
│       └── ci.yml                 <-- Task 5: GitHub Actions CI workflow (Maven + Docker)
│
├── src/
│   ├── main/
│   │   ├── java/com/devops/lab/
│   │   │   ├── FeedbackApplication.java     <-- Spring Boot Application entrypoint
│   │   │   ├── controller/
│   │   │   │   └── FeedbackController.java  <-- Handles form display & submission
│   │   │   └── model/
│   │   │       └── Feedback.java            <-- Data model (Name, Email, Category, Rating, Comments)
│   │   └── resources/
│   │       ├── application.properties       <-- Server port & configurations (port 8080)
│   │       └── templates/
│   │           ├── feedback-form.html       <-- Task 1: Complete HTML feedback form
│   │           └── feedback-result.html     <-- Submission feedback view
│   └── test/
│       └── java/com/devops/lab/
│           └── FeedbackApplicationTests.java <-- Unit test step for Maven/Jenkins
│
├── index.html                     <-- Task 1: Standalone HTML form option
├── Dockerfile                     <-- Task 6: Multi-stage Docker container build
├── Jenkinsfile                    <-- Task 4: Jenkins declarative pipeline script
├── pom.xml                        <-- Task 2: Maven configuration file
├── .gitignore                     <-- Git ignore rules
└── README.md                      <-- Step-by-step instructions and checkpoint screenshot guide
```

---

## Step-by-Step Lab Execution & Checkpoint Evidence Guide

Follow these steps in sequence to capture all 6 required checkpoints for your evidence PDF.

### Task 1: Online Feedback Form
The form contains the required fields:
- **Name** (Text field)
- **Email** (Email validation)
- **Feedback Category** (Dropdown: Course Content, Lab Infrastructure, Instruction/Teaching, General Suggestion)
- **Rating** (Radio buttons 1 to 5)
- **Comments** (Textarea)
- **Submit button**

> **Checkpoint 1 Evidence:**
> Open your browser and navigate to:
> - Standalone: Open `index.html` in your browser.
> - Or when Spring Boot is running: Open `http://localhost:8080`
> Take a full screenshot showing the feedback form loaded in the browser.

---

### Task 2: Maven Project Build
1. Open PowerShell or Terminal in the project root:
   ```powershell
   mvn clean package
   ```
2. Verify that the build succeeds and generates:
   `target/online-feedback-form-1.0.0.jar`

> **Checkpoint 2 Evidence:**
> Take a screenshot of the terminal output displaying `[INFO] BUILD SUCCESS` and the generated JAR in `target/`.

---

### Task 3: Git & GitHub Workflow (Branching, Commit, PR/Merge)
1. Initialize the git repository and add all files:
   ```powershell
   git init
   git add .
   git commit -m "feat: initial commit of online feedback form and devops pipeline"
   ```
2. Create and switch to a feature branch:
   ```powershell
   git branch -M main
   git checkout -b feature/feedback-form
   ```
3. Add your GitHub remote repository:
   ```powershell
   git remote add origin https://github.com/<your-username>/<your-repo-name>.git
   git push -u origin feature/feedback-form
   ```
4. Merge or create Pull Request:
   - **Option A (GitHub Web UI):** Go to GitHub repo -> Open Pull Request from `feature/feedback-form` into `main` -> Click "Merge pull request".
   - **Option B (Command Line Merge):**
     ```powershell
     git checkout main
     git merge feature/feedback-form
     git push origin main
     ```

> **Checkpoint 3 Evidence:**
> Take a screenshot of:
> - The Git terminal showing `git checkout -b feature/...` and `git commit` / `git merge`, OR
> - The GitHub Pull Request merged page showing branches and commit history.

---

### Task 4: Jenkins Pipeline
1. Open Jenkins (`http://localhost:8080` or lab Jenkins URL).
2. Create a **New Item** -> Name it `online-feedback-form-pipeline` -> Select **Pipeline** -> Click **OK**.
3. In Pipeline Definition:
   - Select **Pipeline script from SCM** -> Git -> Enter your repository URL, or
   - Select **Pipeline script** and paste the contents of `Jenkinsfile`.
4. Click **Save** and click **Build Now**.

> **Checkpoint 4 Evidence:**
> Take a screenshot of the Jenkins Pipeline stage view showing all green stages (Checkout, Build with Maven, Test, Package, Archive Artifacts) and "SUCCESS" in the build history.

---

### Task 5: GitHub Actions CI Workflow
1. The workflow file is located at `.github/workflows/ci.yml`.
2. When you push to branch `main` or `feature/*`, GitHub Actions automatically triggers.
3. Open your GitHub repository in browser -> Click on the **Actions** tab.
4. Select the **Maven CI and Docker Build** workflow run.

> **Checkpoint 5 Evidence:**
> Take a screenshot of the GitHub Actions run showing green checkmarks for:
> - `Build & Test with Maven`
> - `Build Docker Image`

---

### Task 6: Docker Containerization
1. Build the Docker image locally:
   ```powershell
   docker build -t online-feedback-form:latest .
   ```
2. Verify the image was created:
   ```powershell
   docker images | grep online-feedback-form
   # on Windows PowerShell:
   docker images | Select-String "online-feedback-form"
   ```
3. Run the container:
   ```powershell
   docker run -d -p 8080:8080 --name feedback-app online-feedback-form:latest
   ```
4. Verify the container is running:
   ```powershell
   docker ps
   ```
5. Access in browser: `http://localhost:8080`

> **Checkpoint 6 Evidence:**
> Take a split or full screenshot showing:
> 1. Terminal with `docker build`, `docker images`, and `docker ps` showing status `Up`.
> 2. Web browser at `http://localhost:8080` showing the live form loaded from the container.

---

### Evidence Compilation Checklist
Compile your screenshots into a single PDF with the following structure:
- **Page 1:** Name, Roll Number, Question Number (Question 2 – Online Feedback Form).
- **Page 2:** Checkpoint 1 (Feedback form in browser).
- **Page 3:** Checkpoint 2 (Maven clean package BUILD SUCCESS).
- **Page 4:** Checkpoint 3 (GitHub feature branch, commit, and PR/merge).
- **Page 5:** Checkpoint 4 (Jenkins pipeline success).
- **Page 6:** Checkpoint 5 (GitHub Actions successful workflow run).
- **Page 7:** Checkpoint 6 (Docker image build, `docker ps`, and running container in browser).
