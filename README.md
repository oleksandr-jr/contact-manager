# contact-manager

# Usage
**Команди** (add, search, edit, delete, list)

```
Usage: phonebook [-hV] [COMMAND]
CLI для управління контактами в телефонній книзі
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
   --add/-a     Додає новий контакт до телефонної книги
   --search/-s  Шукає контакт за ім'ям
   --edit/-e    Редагує існуючий контакт за ім'ям
   --delete/-d  Видаляє контакт за ім'ям
   --list/-ls   Виводить усі контакти
```



**add**
```
Usage: phonebook --add [-hV] -n=<name> -e[=<emails> [<emails> [<emails>]]] [-e
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
Usage: phonebook --search [-hV] [<name>]
Шукає контакт за ім'ям
      [<name>]    Ім'я для пошуку
  -h, --help      Show this help message and exit.
```

Приклад: phonebook -s Jhon

**edit**
```
Usage: phonebook --edit/-e [-hV] [<id>]
Редагує контакт за ID 
      [<id>]    ID контакту для редагуваняя
  -h, --help    Show this help message and exit.
```
### Приклад:
```

> java -jar phonebook.jar -ls
 
| ID         | FULL NAME            | PHONE                          | EMAIL                                        | 
| 5072       | Chris Hemsworth      | +380671111111, +380672222222   | chris.h@m.ua, chris.h@gmail.com              |
| 335        | Chris Pratt          | +380673333333, +380674444444   | chris.p@m.ua, chris.p@gmail.com              |
| 3790       | Scarlett Johansson   | +380675555555, +380676666666   | Scarlett.j@m.ua, Scarlett.j@gmail.com        |
| 2222       | Jeremy Renner        | +380677777777, +380678888888   | Jeremy.r@m.ua, Jeremy.r@gmail.com            |

> java -jar phonebook.jar -e 2222

| ID         | FULL NAME            | PHONE                          | EMAIL                                        | 
| 2222       | Jeremy Renner        | +380677777777, +380678888888   | Jeremy.r@m.ua, Jeremy.r@gmail.com            |

Телефонна книга - виберiть команду:
1. Редагувати iм'я
2. Редагувати телефони
3. Редагувати email
4. Вийти
Ваш вибiр: > 1

1. Введiть нове iм'я: > Jeremy Smit

Контакт оновлено:
| ID         | FULL NAME            | PHONE                          | EMAIL                                        | 
| 2222       | Jeremy Smit          | +380677777777, +380678888888   | Jeremy.r@m.ua, Jeremy.r@gmail.com            |

```


**delete**

```
  Usage: phonebook --delete [-hV] -n=<name>
Видаляє контакт за ім'ям
  -h, --help          Show this help message and exit.
  -n, --name=<name>   Ім'я для видалення
```

Приклад: phonebook -d "Jhon Snow"

**list**

```
  Usage: phonebook --list [-hV]
Виводить усі контакти
  -h, --help      Show this help message and exit.
```

Приклад: phonebook -ls
