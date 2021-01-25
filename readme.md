fork from https://gitlab.com/gitlab-org/project-templates/kotlin-native-linux
with simple script to copy shared libs 
and so add docker support for tiny images *FROM SCRATCH* :)

[init_shared_libs.sh](init_shared_libs.sh) copies all the visible libs from the build dir to a shared folder
idea inspired by Marc Reichelt - https://dev.to/mreichelt/christmas-hacking-squeezing-kotlin-native-into-docker-6ao
the [Dockerfile](Dockerfile) copies the shared folders to the docker root dir

> Some final note: If you compile your own (real) Kotlin Native program, you probably need more files than you might think. Using https connections? I bet you'll need the SSL root certificates provided in each Linux distro. Using some Kotlin Native libs? Maybe some of those add references to other native .so libs, and your program won't start otherwise. So always test sensibly!

--- original readme:

# Kotlin Linux Template

A basic template for developing Linux programs using 
[Kotlin Native](https://kotlinlang.org/docs/reference/native-overview.html). This templates uses 
[Kotlin](http://kotlinlang.org/) 1.4.10, and covers the following Kotlin Native Linux targets:

- [linuxArm32Hfp](src/linuxArm32Main) (supports ARM v7 CPU)
- [linuxArm64](src/linuxArm64Main) (supports ARM v8 CPU)
- [linuxX64](src/linuxX64Main) (supports AMD64 based CPUs)

It is important to note that a Kotlin Native Linux binary will **only work** on a supported CPU, where the device is 
running a Linux distribution that bundles [glibc](https://www.gnu.org/software/libc/) (Ubuntu, Debian, Linux Mint etc), 
**NOT** [Musl Libc](https://www.musl-libc.org/) (eg Alpine Linux). Currently there is an unresolved issue in the Kotlin 
issue tracker on [running binaries on Alpine Linux](https://youtrack.jetbrains.com/issue/KT-38876).


## Gradle Tasks

Use the `runLinux_appDebugExecutableLinuxX64`, or `runLinux_appReleaseExecutableLinuxX64` Gradle task to run a Linux 
X64 program. Binaries for other targets must be run manually outside of Gradle. To generate a Linux debug binary 
(contains debugging information) use one of the following Gradle tasks:

- linkLinux_appDebugExecutableLinuxX64
- linkLinux_appDebugExecutableLinuxArm32
- linkLinux_appDebugExecutableLinuxArm64

To generate a Linux release binary (stripped of debugging information) use one of the following Grade tasks:

- linkLinux_appReleaseExecutableLinuxX64
- linkLinux_appReleaseExecutableLinuxArm32
- linkLinux_appReleaseExecutableLinuxArm64

Build artifacts can be removed by running the `clean` Gradle task.
