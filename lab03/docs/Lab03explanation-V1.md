# **Lab03 Diagram Explanation**

# ***Activity Diagram***

## **Overview**

**Why drawing diagrams**

Even though we have completed the text analysis diagram, and found out different stakeholders and detailed use cases, we still **don’t know the internal relationship of these use cases**. We desire a diagram which could clearly **display the whole workflow for the entire system**. In addition, the ideal diagram had better enable us to include some **decision points** and **parallel activities** in it, in account of the fact that a student’s application might be considered by both module convenor and head of teaching at the same time.

 **Why activity diagrams**

To achieve this goal, we analyze many diagrams. In the end, we discover that the activity diagram can fully satisfy our need. First, the **chronological order** of all use cases is easy to be expressed by using activity diagram. Besides, activity diagram is able to show the condition under which one use case will happen, which is greatly helpful to construct the workflow **containing many decision points**. What’s more, some events **happening concurrently** could also be displayed in this diagram by utilizing “bar”. Due to these advantages mentioned above, we finally decide to use activity diagram.

**Here is our diagram:**

![alt text](../diagrams/activityDiagram.jpg)


In the following part, we will discuss the Detailed Flows and Clarification. 

In the Detailed Flows, we mainly discussed the actors and their corresponding actions. Also, we talked about the general flows of the program as well as how the decision is made in the note part.

In the Clarification, we state our solutions to the vague part of the requirements and our choices for the conflicts over understandings.

&nbsp;
## **Detailed flows**

### **Actors/Actions:**
- **Student service:**
  - create the form
  - check credit split 
  - send notification
  - check approvals
  - release results
- **Student:**
  - search the form
  - fill the form
  - upload evidence(optionally)
  - submit the form
  - view results
- **Module Convenor:**
  - view evidence
  - view class size
  - submit decisions
- **Head of Teaching:**
  - view evidence
  - view grades
  - submit decisions



&nbsp;
### **Steps:**

 1. Student service creates a form and releases it for student.  
 2. Students search for a form, fill the form, in this step, and then submit it. Students can optionally upload some evidence if required. 
 3. After student submit the form, the student service will check the form automatically and decide whether to notify the module convenor/the Head of Teaching
 4. For forms that doesn't need approval from the module convenor or head of teaching, the student service will automatically check the credit and make an approval.
 5. After receiving notification from the student service, the module convenor and Head of Teaching will check these forms, give their decisions based on their authority and send the results back to the student service. These actions will be done parallelly.
 6. After recieving results from the module convenor/ the Head of Teaching, the student service check the approvals, make the final decision and release the results
 7. The students can view these results



&nbsp;
### **Note:**

- Only students who want to take credit split,  take introductory module from another department or take pre-requisite module are required to provide the evidence. Others don't need to submit the evidence.

-  After recieving forms, student service will first check students' choices. If some forms need to be approved, the head of teaching and module convenor will be notified to check these forms. For other forms, they will be automatically approved.

- Module convenor will deal with forms that express the intention to take introductory module from another department or take credit split. By checking the class size and ensuring its feasibility, the module convenor will make a decision -- only the class size is avalible and the evidence is sufficient will the form be approved.

- Head of Teaching will deal with forms which express students' demands for taking other pre-requisite module or taking credit split. By checking the students' grades, the Head of Teaching will give a result -- only those who have good performance at school will be approved.

- The student service will check approvals from both Head of Teaching and module convenor. If one of them does not approve, the result will be failed.

&nbsp;

## **Clarification**
&nbsp;
#### ***Question:*** *Should the rejections from module convenor and head of teaching be performed in the diagram?*

#### ***Answer:*** *Yes, since activity diagram is used to explain the decision points and tell the clients what the results would be like in different conditions, we hold the viewpoint that these rejections should be performed in the diagram.*

&nbsp;
#### ***Question:*** *In this diagram, does student service need to send forms which require approval to either the head of teaching or module convenor? Or just let both the head of teaching and module convenor view all these forms and then make a decision?*

#### ***Answer:*** *Because this is a completed system, we think that there is no need to 'send'. Nevertheless, it is impossible for module convenors and the head of teaching to view all these forms. Therefore, we decide to make this action be 'send the notification', which means inviting these teachers to view these particular forms.

