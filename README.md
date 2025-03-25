# DSL for Fitness and Nutrition Management

## 📌 Project Overview
A Domain-Specific Language (DSL) that integrates **fitness planning** and **nutrition management** into a unified system. Automates personalized workout routines and meal plans based on user goals, dietary preferences, and health metrics.

### Key Features
- 🏋️ **Fitness Planning**: Custom workouts (intensity, duration, exercise type)
- 🥗 **Nutritional Management**: Meal plans aligned with workouts and dietary needs
- 🔄 **Dynamic Adjustments**: Adapts plans based on progress
- ⚖️ **BMI Calculator**: Tracks body mass index
- 📊 **Daily Reports**: Summarizes weight, water intake, calories, etc.
- 🩸 **Menstruation Calendar**: For female users (exercise recommendations)
- 🔗 **Integration**: Works with external apps/databases

---

## ❓ Problem Statement
> *"Existing apps force users to juggle separate tools for fitness and nutrition, leading to inefficiency and health risks."*

**Gaps addressed**:
- Manual coordination between disjointed systems
- Lack of personalization
- No real-time progress tracking

---

## 🎯 Target Audience
| Group | Needs |
|-------|-------|
| Fitness Enthusiasts | Structured workouts + meal plans |
| Busy Professionals | Time-efficient planning |
| Dietary-Restricted Users | Tailored meal options |
| Trainers/Nutritionists | Client management tools |

---

## 💻 Technical Implementation
### Lexer and Parser
The DSL includes a **lexer and parser** to process user inputs and generate plans. Key components:

- **Lexical Elements**: Keywords, identifiers, literals, operators, and punctuation.
- **Syntactic Structures**: Defined using BNF rules for statements, conditions, loops, and outputs.
- **Execution Rules**: Data loading, object creation, filtering, and plan generation.

### Example Usage
#### Meal Plan
```plaintext
using dbo.food
using person.ID = 1
foreach person.food.parameter {
    include parameter into generation
}
while (parameters != done) {
    generate food.recipe schedule update
}

for (meals) {
    output meal.recipe.link
}
```

#### Training Plan
```plaintext
using dbo.sport
using dbo.food
using person.ID = 1
generate training (time avg, amount avg_not_specified, type w_gear_not_specified, goal fit, Person person)
output training as description table

while (time.max) {
    output rep time
    output rest time
}
```

## Stakeholders
| Stakeholder | Role | Needs/Pain Points |
|------------|------|-------------------|
| **End users** | Fitness enthusiasts, athletes | Time-efficient planning, personalized routines |
| **Fitness trainers** | Personal trainers | Client management tools, evidence-based recommendations |
| **Nutrition adepts** | Nutritionists, meal prepping enthusiasts | Meal planning tools, dietary recommendations |
| **Researchers** | Sport science researchers, data analysts | Tracking system, data-driven insights |

## Technical Challenges
- **Data Standardization**: Handling inconsistent calorie measurements and diverse ingredients.
- **Algorithm Accuracy**: Ensuring reliable recommendations based on user inputs.
- **User Accessibility**: Balancing simplicity and flexibility for non-technical users.
- **Integration**: Compatibility with external apps and databases.
- **Security**: Protecting sensitive health and dietary data.

## Project Team
| Member | Responsibilities |
|--------|-----------------|
| **Belih Dmitrii (Team Leader)** | Oversees application development and process. |
| **Tatarentev Denis** | Handles food-related logic and DSL functionality. |
| **Bujor-Cobili Alexandra** | Develops the lexer and collaborates on the parser. |
| **Rudenco Ivan** | Manages visualization and server integration. |
| **Mihalevschi Alexandra** | Assists in DSL and server development. |

