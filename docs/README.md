# Handsome User Guide

![Ui picture](/Ui.png)

### Handsome is a chat bot that helps users manage their tasks. Below are the features available.

## Adding todo: ```todo <task description>```

### Add a todo task to the task list.

Example: `todo buy book`

Expected output: 
```
Got it. I've added this task:
[T][] buy book
"Now you have 1 tasks in the list. (included archived tasks) 
```

## Adding deadline: ```deadline <description> /by <date>```

### Add a deadline task to the task list.

Example: `deadline return book /by 2024-12-23 1600`

Expected output:
```
Got it. I've added this task:
[D][] return book (by: Mon, 23 Dec 2024, 04:00 PM)
"Now you have 2 tasks in the list. (included archived tasks) 
```

## Adding event: ```event <description> /from <date> /to(date)```

### Add an event task to the task list.

Example: `event party /from 2024-12-12 1600 /to 2024-12-12 1700`

Expected output:
```
Got it. I've added this task:
[E][] party (from: Thu, 12 Dec 2024, 04:00 PM to: Thu, 12 Dec 2024, 05:00 PM)
"Now you have 3 tasks in the list. (included archived tasks) 
```

## Marking task: ```mark <task index>```

### Mark a task in task list as done.

Example: `mark 1`

Expected output:
```
Nice! I've marked this task as done:
[T][X] buy book
```

## Unmarking task: ```unmark <task index>```

### Mark a task in task list as not done.

Example: `unmark 1`

Expected output:
```
Ok, I've marked this task as not done yet:
[T][ ] buy book
```

## Deleting task: ```delete <task index>```

### Delete a task from tasks list.

Example: `delete 1`

Expected output:
```
Noted. I've removed this task:
[T][ ] buy book
```

## Listing the tasks: ```list```

### Show all tasks in task list.

Example: `list`

Expected output:
```
Here are the tasks in your list:
1.[D][ ] return book (by: Mon, 23 Dec 2024, 04:00 PM)
2.[E][ ] party (from: Thu, 12 Dec 2024, 04:00 PM tp: Thu, 12 Dec 2024, 05:00 PM)
```

## Showing prompts ```prompt```

### Show all prompts available.

Example: `prompt`

Expected output:
```
1. todo <description>: Add a todo task
2. deadline <description> /by <date> (date format: yyyy-mm-dd <time in 24 hr format>): Add a deadline task
3. event <description> /from <date> /to <date> (date format: yyyy-mm-dd <time in 24 hr format>): Add an event task
4. mark <task index>: Mark <index> task as done
5. unmark <task index>: Mark <index> task as not done
6. delete <task index>: Delete <index> task from tasks list
7. list: Show the current tasks list
8. prompt: Show the available commands
9. bye : Exit and close the chat bot
10. archive: Archive the task list
11. unarchive: Unarchive the task list
```

## Archiving the list: ```archive```

### Archive the task list so that all current tasks will not be shown till unarchived to achieve a clean state.

Example: `archive`

Expected output:
```
Task List is successfully archived!
```
The list will not show previous items when ```list``` is called.

## Unarchiving the list: ```unarchive```

### Unarchive the task list so that all archived tasks will show in the list again. 

Example: `unarchive`

Expected output:
```
Task List is successfully unarchived!
```
The list will now show archived items when ```list``` is called.
