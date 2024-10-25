# contact-manager

# Usage
**Команди** (add, search, edit, delete, list)

```
Usage: phonebook [-hV] [COMMAND]
CLI для управління контактами в телефонній книзі
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
   add, -a     Додає новий контакт до телефонної книги
   search, -s  Шукає контакт за ім'ям
   edit, -e    Редагує існуючий контакт за ім'ям
   delete, -d  Видаляє контакт за ім'ям
   list, -ls   Виводить усі контакти
```



**add**
```
Usage: phonebook add [-hV] -n=<name> -e[=<emails> [<emails> [<emails>]]] [-e
                     [=<emails> [<emails> [<emails>]]]]... -p[=<phones>
                     [<phones> [<phones>]]] [-p[=<phones> [<phones>
                     [<phones>]]]]...

Додає новий контакт до телефонної книги
  -e, --email[=<emails> [<emails> [<emails>]]]           Електронна пошта
  -h, --help                                           Show this help message and exit.
  -n, --name=<name>                                      Ім'я контакту
  -p, --phone[=<phones> [<phones> [<phones>]]]            Номер телефону
```


Приклад: phonebook add -n "Jhon Snow" -p 123456789 22233333 -e 123@qq.ua 234@qq.ua

**search**

```
Usage: phonebook search [-hV] [<name>]
Шукає контакт за ім'ям
      [<name>]    Ім'я для пошуку
  -h, --help      Show this help message and exit.
```

Приклад: phonebook -s Jhon

###   Що до **edit** потрібно вирішити чи потрібна команда, чи досить add з перезаписом

**delete**

```
  Usage: phonebook delete [-hV] -n=<name>
Видаляє контакт за ім'ям
  -h, --help          Show this help message and exit.
  -n, --name=<name>   Ім'я для видалення
```

Приклад: phonebook -d "Jhon Snow"

**list**

```
  Usage: phonebook list [-hV]
Виводить усі контакти
  -h, --help      Show this help message and exit.
```

Приклад: phonebook -ls
