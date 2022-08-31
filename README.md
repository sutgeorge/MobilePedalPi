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
- [ ] Read about Kotlin Jetpack Compose
- [ ] Read about Kotlin Android Bluetooth connectivity
- [ ] Create UML diagrams for the app structure
- [ ] Re-read/refresh knowledge on design patterns
- [ ] Think of design patterns that could be used
- [ ] Buy components
- [ ] Assemble the components
- [ ] Install Hifiberry DAC+ADC soundcard drivers on Raspberry Pi
- [ ] Install Pure Data on Raspberry Pi
- [ ] Test whether the Puredata effect works with the guitar (Big Jack/small Jack adapter for the guitar cable plugged into the laptop)
- [ ] Implement a quick initial version of the app
- [ ] Finish a full initial version of the app
- [ ] Test it
- [ ] Create a demo video
- [ ] Update README.md

## Resources

### Project management
- [How to create a PERT chart](https://asana.com/resources/pert-chart)
- [9 Best Open-Source Gantt Chart Software For Linux](https://itsfoss.com/open-source-gantt-chart/) 

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
- [Pure Data Guitar Pedal - Pure Data Example Project](https://www.youtube.com/watch?v=DJCoOr4uHD4)
- [Sound Simulator - Pure Data Tutorial #1 - Simple Button + Message + Object patch](https://www.youtube.com/watch?v=1o5Wasmd8yU)
- [Sound Simulator - Pure Data Tutorial #2 - Additive Synth, Overtone Generator](https://www.youtube.com/watch?v=JtT_bZeoKzk)
- [Sound Simulator - Pure Data Tutorial #3 - Subtractive Synth, Low-Pass, High-Pass, Band-pass Filters](https://www.youtube.com/watch?v=FVYkQFP1_D4)
- [Sound Simulator - Pure Data Tutorial #4 - Attack-Decay-Sustain-Release Envelope](https://www.youtube.com/watch?v=W7Pp-DhMA_E)
- [Pd for Airports](https://www.youtube.com/watch?v=7sTrn39TT7k)

### Hifiberry

- [Updating the kernel for the Hifiberry DAC+ADC soundcard drivers (might not be necessary nowadays, the kernel most likely contains the necessary drivers)](https://www.hifiberry.com/docs/archive/deploying-a-new-linux-kernel-onto-a-raspbian-based-system/)

## Setup diagram

![MobilePedalPi setup diagram](/Diagram-Images/diagram.png)

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

## Some remarks

- 1/4" Jack &rarr; 6.35 mm
- 1/8" Jack &rarr; 3.5 mm

## Other projects
- [Multi-effects guitar pedal with touchscreen](https://www.youtube.com/watch?v=JoJEhhwpi9Q)
- [NeuralPi](https://www.youtube.com/watch?v=_3zFD6h6Wrc)
- [Guitar audio to polyphonic MIDI in real time with Pure Data and Python](https://www.youtube.com/watch?v=GwEdOo7iPuA)
