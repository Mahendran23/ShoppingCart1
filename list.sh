for h in `git log --pretty=format:"%h" --since="2019-05-26"`; do
  git show --pretty="format:" --name-only  $h
done | sort | uniq
