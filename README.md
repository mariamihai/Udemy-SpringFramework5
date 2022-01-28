# Udemy-SpringFramework5

Based on Udemy Course [Spring framework 5: Beginner to guru](https://www.udemy.com/course/spring-framework-5-beginner-to-guru/).

This repo consists of 3 independent projects I merged. They all use Java 8.

## Merging multiple repositories

Start with a repo that has at least one commit (it contains a master / main branch).

For simplicity, make sure the new repo files are in a folder.

Add a remote for the repo to be merged:
> git remote add -f another_repo <Another repo URL>

Merge the files into current repo master branch:
> git merge another_repo/master --allow-unrelated-histories

Remove the remote for the added repo:
> git remote remove another_repo

The history is now concatenated and the second repository can be deleted.

## Status

**[COMPLETED]** - I am setting a personal status of "Completed" and will probably not update this repository in the near future as this was a learning project.
