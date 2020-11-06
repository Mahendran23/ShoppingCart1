for h in `git log --pretty=format:"%h" --since="2020-07-05"`; do
  git show --pretty="format:" --name-only  $h
done | sort | uniq
