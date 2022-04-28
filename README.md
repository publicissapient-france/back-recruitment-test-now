# Live coding back-end

## Introduction 

The company PS-now, expert in the courier delivery industry in Metropolitan France (Only continental territories), wants to automate its existing process to ship and deliver packages. You’ll have to design a system to support its changing process.

## Use case 1

Start off by creating a CLI that allows you to interface with the old system. For that, the old system generates files with the delivery information. You’ll have to read and parse this file to obtain the delivery information.

example of the entry file:

```
last_name, first_name, address, city, postal_code, delivery_date, delivery_center
Doe, John,  1234 Boulevard Dupin, Paris ,  75015, 10/03/2022, North
Ann, Mary, 5678 Rue Lafayette, Strasbourg, 67000, 11/03/2022, East
```
To be able to interface with the Mail Delivery System You need to write a file with the body of an email to the customer with the information of his/her delivery date

```
Subject: Your package is on the way !

Dear <first_name> <last_name>, your delivery is on the way and will arrive on <delivery_date>.
```

The Mail Delivery System runs frequently.


## Use case 2

Each package forms part of a delivery group, which consists of 1..N packages belonging to the same Region. There are 4 regions: North, South, East, West. Each one represents a delivery center.
The legacy system cannot guarantee that all packages belonging to a delivery center will be sent together, so it is up to the new system to send these packages.
All the available deliveries are present in the file sent by the legacy system. You need to generate a new file containing all package delivery instructions grouped by delivery center (only one file).
The new delivery file must contain the following structure ordered by :
```
<Delivery_center1>
<address>,<last_name><first_name>,<delivery_date>,<delivery_id>
<address>,<last_name><first_name>,<delivery_date>,<delivery_id>
…
<Delivery_center2>
…
```

where delivery_id is an unique identifier to the delivery with no particular meaning in the way it is formed. 
Each delivery center has its own delivery restrictions:
###North: 
Accepts deliveries all the time
###East:
If the package is to be delivered on monday or thursday, it needs to be changed to the North delivery center
###West:
if the packages is to be delivered on tuesday or friday,  it needs to be changed to the South delivery center
###South:
if the package is to be delivered on wednesday or saturday, send to East
Question:
Suppose that deliveries in the original file can be duplicated due to a bug of the legacy system. What would you do if you need to be sure that the delivery will appear only once in the final file? The package can be identified by name, last_name and address.

## Use case 3

You just received news that the new system should allow you to cancel deliveries. ignore the implementation details for the moment. You are asked to define a way to expose an interface for allowing the cancel system to announce the delivery cancellation. You think about  exposing an interface of type:

```
public interface packageSender {
void pack(Package clientPackage);
}
```

How would you expose the mentioned interface as an API?

## Use case 4

You are free to present to the architecture departement how you would imagine the solution of the new system including the replacement of the legacy system and the new requirements. The company trusts in your competencies to propose something innovative and scalable.

