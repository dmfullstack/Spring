5 types of bean scopes supported :

singleton(default) – Return a single bean instance per Spring IoC container
prototype – Return a new bean instance each time when requested
request – Return a single bean instance per HTTP request. *
session – Return a single bean instance per HTTP session. *
globalSession – Return a single bean instance per global HTTP session. *