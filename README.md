# MobilePedalPi
A Kotlin/Android Raspberry Pi-based app serving as a convenient replacement for a commercial guitar pedal. 

## Chronological to-do list
- [X] Create to-do list
- [X] Establish in Google Calendar a timeframe for working on the project
- [X] Read about Puredata
- [X] Read about Puredata guitar effects
- [X] Watch Puredata tutorials on basic objects
- [X] Create a Puredata effect
- [X] Create basic ugly diagram of the project
- [X] Read about other Raspberry Pi guitar pedal projects with Hifiberry
- [X] Watch Pure Data tutorials on input devices and subpatches
- [X] Watch Pure Data tutorials on various effects
- [X] Read about how to install Puredata on Raspberry Pi and save the link in the "Resources" section
- [X] Read about how to install Hifiberry DAC+ADC soundcard drivers on Raspberry Pi
- [X] Read about UI/UX for mobile apps
- [X] Think about what elements are necessary in the user interface
- [X] Create wireframes for the UI
- [X] Add the actual images and colors on top of the wireframes for an initial version of the UI
- [X] Buy components
- [X] Assemble the components
- [X] Install Hifiberry DAC+ADC soundcard drivers on Raspberry Pi
- [X] Install Pure Data on Raspberry Pi
- [X] Check if the soundcard works by running a test script from Hifiberry (it generates a sine wave of 1000 Hz)
- [X] Read about Kotlin Jetpack Compose
- [X] Read about Kotlin Android Bluetooth connectivity
- [X] Search articles explaining how to port a Kotlin/Android app to iOS
- [X] Test whether the Puredata effect works with the guitar (Big Jack/small Jack adapter for the guitar cable plugged into the laptop)
- [X] Create diagrams for the app structure
- [ ] Create a diagram of the physical cabling for the pedal, guitar and amp
- [ ] Re-read/refresh knowledge on design patterns
- [ ] Think of design patterns that could be used
- [ ] Run Pure Data on the Raspberry Pi and check if the guitar can be heard in-real-time with the headphones 
- [ ] Install ElkAudioOS or HifiberryOS (if neither the adjusted sound card settings nor the cabling improve the sound quality) 
- [ ] Implement a quick initial version of the app
- [ ] Finish a full initial version of the app
- [ ] Test it
- [ ] Create a demo video
- [ ] Update README.md

## Resources

### Pure Data
- [Installing Pure Data on Raspberry Pi](http://pi.bek.no/pdInstall/)
- [Pure Data documentation](http://archive.flossmanuals.net/pure-data/)
- [Pure Data documentation - PDF](http://archive.flossmanuals.net/_booki/pure-data/pure-data.pdf)
- [List of Pure Data objects](http://blazicek.net/list_of_pure_data_objects.html)
- [Pure Data Reference Card](https://puredata.info/docs/tutorials/pd-refcard)
- [Running Pure Data on a headless Raspberry Pi](https://guitarextended.wordpress.com/2012/08/28/running-pd-on-a-headless-raspberry-pi/)
- [Pure Data Filters](https://archive.flossmanuals.net/pure-data/audio-tutorials/filters.html)
- [Pure Data Tutorial](https://puredata.info/docs/StartHere/)
- [Pure Data error: "priority 6 scheduling failed; running at normal priority"](https://www.reddit.com/r/puredata/comments/88uwyo/installing_pd_for_linux_mint_18/)
- [Pure Data external programming in C](https://www.youtube.com/watch?v=Ysjf78lP5zw)


```
 Solution:
	1. Update Kernel    
	2. Create audio group: sudo groupadd audio
	3. Add your user to audio group: sudo gpasswd -a <username> audio
	4. Create group limits file for audio group: sudo nano /etc/security/limits.d/audio.conf
	5. Add the following lines to audio.conf:
  
 		@audio   -  rtprio     95
		@audio   -  memlock    unlimited
		#@audio   -  nice       -19
 
	6. Reboot
```


- [Pure Data Guitar Pedal - Pure Data Example Project](https://www.youtube.com/watch?v=DJCoOr4uHD4)
- [Sound Simulator - Pure Data Tutorial #1 - Simple Button + Message + Object patch](https://www.youtube.com/watch?v=1o5Wasmd8yU)
- [Sound Simulator - Pure Data Tutorial #2 - Additive Synth, Overtone Generator](https://www.youtube.com/watch?v=JtT_bZeoKzk)
- [Sound Simulator - Pure Data Tutorial #3 - Subtractive Synth, Low-Pass, High-Pass, Band-pass Filters](https://www.youtube.com/watch?v=FVYkQFP1_D4)
- [Sound Simulator - Pure Data Tutorial #4 - Attack-Decay-Sustain-Release Envelope](https://www.youtube.com/watch?v=W7Pp-DhMA_E)
- [Pd for Airports](https://www.youtube.com/watch?v=7sTrn39TT7k)

### Raspberry Pi/Hifiberry
- [Running a headless Raspberry Pi through SSH](https://www.tomshardware.com/reviews/raspberry-pi-headless-setup-how-to,6028.html)
- [Updating the kernel for the Hifiberry DAC+ADC soundcard drivers (might not be necessary nowadays, the kernel most likely contains the necessary drivers)](https://www.hifiberry.com/docs/archive/deploying-a-new-linux-kernel-onto-a-raspbian-based-system/)
- [Hifiberry software configuration](https://www.hifiberry.com/docs/archive/hifiberry-software-configuration/)
- [Playing test sounds](https://www.hifiberry.com/docs/software/playing-test-sounds/)
- [Configuring Hifiberry for Linux 5.4 or higher kernel version](https://www.hifiberry.com/docs/software/configuring-linux-3-18-x/)
- [Raspberry Pi Wi-Fi & Bluetooth Setup](https://www.digikey.ro/en/maker/blogs/raspberry-pi-wi-fi-bluetooth-setup-how-to-configure-your-pi-4-model-b-3-model-b)
- [How To Set Up Bluetooth On Raspberry Pi](https://howchoo.com/pi/bluetooth-raspberry-pi)
- [bluetoothctl: list connected devices](https://superuser.com/questions/1500383/bluetoothctl-list-connected-devices)
- [Recording audio on Raspberry Pi with Hifiberry](https://www.hifiberry.com/docs/software/record-audio-on-your-raspberry-pi/)
- [Install BlueZ on Raspberry Pi](https://www.argenox.com/library/bluetooth-low-energy/using-raspberry-pi-ble/)

Adding `#include <linux/sockios.h>` to the include section of BlueZ tools/l2test.c and tools/rctest.c solves the ["siocgstamp undeclared" error](https://github.com/LibtraceTeam/libtrace/issues/117).

Default user/password: pi/raspberry

#### Note!

To setup the Raspberry Pi WiFi connection easily, just create a `wpa_supplicant.conf` file and place it in the `boot/` partition of the MicroSD card.

The file should look something like this:

```
country=us
update_config=1
ctrl_interface=/var/run/wpa_supplicant

network={
 scan_ssid=1
 ssid="MyNetworkSSID"
 psk="Pa55w0rd1234"
}
```

### Bluetooth Low Energy

In Bluetooth Low Energy (BLE), the roles of "central" and "peripheral" refer to the two primary device roles in a BLE connection. The central device typically initiates the connection and controls the communication, while the peripheral device responds to the central's requests.

When it comes to data transmission, the communication in BLE is generally initiated by the central device. The central sends data to the peripheral(s) in what is known as the "master-slave" communication model. The central (master) controls the data exchange and can send commands, requests, or data packets to one or more peripherals (slaves) that are connected to it.

Here's a breakdown of the data flow in a typical BLE communication session:

- Central (Master) to Peripheral (Slave): The central initiates communication by sending data packets to the peripheral. These packets may contain commands, data, or requests for information from the peripheral.

- Peripheral (Slave) to Central (Master): The peripheral can respond to the central's requests by sending data packets back to the central. The peripheral cannot initiate communication on its own; it can only respond to the central's requests.

- Connection Interval: BLE communication occurs within specific time intervals known as the "connection interval." During these intervals, the central and peripheral devices exchange data.

- Advertising and Scanning: Before establishing a connection, the peripheral device advertises its presence, and the central scans for nearby peripherals. Once the central discovers the peripheral it wants to communicate with, it initiates the connection process.

Overall, the central device has more control over the data flow and communication process, while the peripheral device responds to the central's requests. This master-slave architecture in BLE allows for efficient and low-power communication, making it suitable for various applications like wearables, IoT devices, and more.

In this case, the Raspberry Pi is a peripheral, while the Android device is a central.

- [Create a BLE GATT server UART service on Raspberry Pi](https://scribles.net/creating-ble-gatt-server-uart-service-on-raspberry-pi/)

### Kotlin Multiplatform

- [Make your Android application work on iOS – tutorial](https://kotlinlang.org/docs/multiplatform-mobile-integrate-in-existing-app.html)

### Kotlin Flow API

SharedFlow and StateFlow are part of the Kotlin Flow API, which is a part of Kotlin's Coroutines library. They are designed for reactive programming and handling streams of data asynchronously. Both SharedFlow and StateFlow are used for similar purposes, but they have some differences in how they handle data sharing and state preservation.

SharedFlow:

SharedFlow represents a hot flow, meaning it can start emitting data even if there are no collectors listening to it. Multiple collectors can listen to the same SharedFlow, and they will all receive the emitted values.
When a new collector starts observing a SharedFlow, it will receive the most recent emitted value (if any) immediately after collecting.
SharedFlow does not preserve state for new collectors. If a collector starts observing a SharedFlow after values have been emitted, it will only receive the new values from that point onwards, not the previous values.

StateFlow:

StateFlow is an extension of SharedFlow and is designed specifically for handling state updates.
StateFlow is a hot flow, similar to SharedFlow, and can start emitting data even if no collectors are listening to it.
However, StateFlow preserves the most recent emitted value, even for new collectors. When a new collector starts observing a StateFlow, it will immediately receive the most recent value.
StateFlow is particularly useful for representing a single source of truth for state management, such as representing the current state of a user interface component.

### Playing Youtube audio with Hifiberry and Raspberry Pi
Run the mpv media player software from the terminal with the Youtube link as the first parameter and the --no-video option in case a monitor is not available:

> mpv https://www.youtube.com/watch?v=u9bk2MrMGaA --no-video

## Setup diagram

![MobilePedalPi setup diagram](/Diagram-Images/diagram.png)

## Raspberry Pi+Hifiberry setup

![Raspberry Pi+Hifiberry setup](/Images/raspberry-pi-with-hifiberry-soundcard.jpg) 

## UI/UX elements needed

### Starting screen

- high-quality close-up image of a guitar at the top of the screen
- short appealing description
- start button
- logo at the bottom of the screen

### Pedal switch screen (first screen)

This screen should allow the user to switch between different pedals by swiping left and/or right, turn them on/off and adjust sound settings. By sliding downwards, the user is led to the second screen.

- Wooden background
- An image of a pedal positioned in the center of the screen + input/output Jack wires 
- The logo is positioned in the upper left corner of the screen

### Pedal pipelines screen (second screen)
The second screen allows the user to build a pipeline i.e. a sequence of pedals, each taking as input either the guitar signal directly or the output of other pedals.

- Wooden background
- Jack ports positioned in the center of each side of the screen 
- At the bottom of the screen, an up-arrow is placed which, if pressed, triggers a pop-up containing multiple options of pedals. The list of pedals can be scrolled horizontally. 
- To place a pedal on the floor, drag it from the pop-up outwards
- To connect pedals to one another, drag cables from the previously-mentioned pop-up

### [Wireframe diagrams](https://wireframe.cc/)

![Starting screen](/Wireframes/starting-screen.jpg)

![First screen](/Wireframes/first-screen.jpg)

![Second screen](/Wireframes/second-screen.jpg)

### Wireframe diagrams with images

![Starting screen](/Wireframes/starting-screen-with-images.jpg)

![First screen](/Wireframes/first-screen-with-images.jpg)

![Second screen](/Wireframes/second-screen-with-images.jpg)

### Project diagram

This diagram is a mixture of a structural and behavioral UML diagram. Since the Jetpack Compose toolkit works based on functions/so-called "composables" rather than classes, a UML class diagram wouldn't make much sense, but aggregation/composition relationships are still used nonetheless. The double-arrowed relationship represents a swipe action prompted by the user. 

![App diagram](/Diagram-Images/app-diagram.png)

### Cabling

- [What happens if you plug a mono plug into a stereo jack?](https://www.homemusicproducer.com/what-happens-if-you-plug-a-mono-plug-into-a-stereo-jack/)

### Cabling diagram

![Cabling diagram](/Diagram-Images/cabling-ports-diagram.png)

## Some remarks

- 1/4" Jack &rarr; 6.35 mm
- 1/8" Jack &rarr; 3.5 mm

## Other projects
- [Multi-effects guitar pedal with touchscreen](https://www.youtube.com/watch?v=JoJEhhwpi9Q)
- [NeuralPi](https://www.youtube.com/watch?v=_3zFD6h6Wrc)
- [Guitar audio to polyphonic MIDI in real time with Pure Data and Python](https://www.youtube.com/watch?v=GwEdOo7iPuA)
