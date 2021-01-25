FROM scratch
COPY build/bin/linuxX64/linux_appReleaseExecutable/linux_app.kexe /usr/bin/linux_app.kexe
COPY shared /
ENTRYPOINT ["/usr/bin/linux_app.kexe"]
